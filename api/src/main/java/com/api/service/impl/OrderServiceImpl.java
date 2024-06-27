package com.api.service.impl;

import com.api.common.utils.OrderTask;
import com.api.common.utils.OrderTaskHandler;
import com.api.mapper.IdleItemMapper;
import com.api.mapper.OrderMapper;
import com.api.mapper.UserMapper;
import com.api.model.dto.IdleItemDto;
import com.api.model.dto.OrderDto;
import com.api.model.entity.IdleItem;
import com.api.model.entity.Order;
import com.api.model.entity.User;
import com.api.model.vo.PageVo;
import com.api.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private IdleItemMapper idleItemMapper;

    @Resource
    private UserMapper userMapper;

    private static HashMap<Integer, ReentrantLock> lockMap=new HashMap<>();
    static {
//        ReentrantLock lock=new ReentrantLock(true);
        for(int i=0;i<100;i++){
            lockMap.put(i,new ReentrantLock(true));
        }
    }


    @Override
    public PageVo<OrderDto> getOrderList(Integer page, Integer size) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        return buildOrderDtoListPageVo(orderQueryWrapper, page, size);
    }

    @Override
    public int deleteOrder(Long orderId) {
        return orderMapper.deleteById(orderId);
    }

    @Override
    public List<OrderDto> getMyOrder(Long userId) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", userId);
        List<Order> orderList = orderMapper.selectList(orderQueryWrapper);
        return buildOrderDtoList(orderList);
    }

    @Override
    public List<OrderDto> getMySoldOrder(Long userId) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", userId);
        orderQueryWrapper.eq("order_status", 1);
        List<Order> orderList = orderMapper.selectList(orderQueryWrapper);
        return buildOrderDtoList(orderList);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("id", id);
        Order order = orderMapper.selectOne(orderQueryWrapper);
        return buildOrderDto(order);
    }

    @Override
    public boolean add(Order order){
        IdleItem idleItemModel =idleItemMapper.selectById(order.getIdleId());
        System.out.println(idleItemModel.getIdleStatus());
        if(idleItemModel.getIdleStatus()!=1){
            return false;
        }
        IdleItem idleItem=new IdleItem();
        idleItem.setId(order.getIdleId());
        idleItem.setUserId(idleItemModel.getUserId());
        idleItem.setIdleStatus((byte)2);

        int key= (int) (order.getIdleId()%100);
        ReentrantLock lock=lockMap.get(key);
        boolean flag;
        try {
            lock.lock();
            flag=addOrderHelp(idleItem,order);
        }finally {
            lock.unlock();
        }
        return flag;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean addOrderHelp(IdleItem idleItem,Order order){
        IdleItem idleItemModel=idleItemMapper.selectById(order.getIdleId());
        if(idleItemModel.getIdleStatus()!=1){
            return false;
        }
        if(idleItemMapper.updateById(idleItem)==1){
            if(orderMapper.insert(order)==1){
                order.setOrderStatus((byte) 4);
                //半小时未支付则取消订单
                OrderTaskHandler.addOrder(new OrderTask(order,30*60));
                return true;
            }else {
                new RuntimeException();
            }
        }
        return false;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean update(Order order){
        //不可修改的信息
        order.setOrderNumber(null);
        order.setUserId(null);
        order.setIdleId(null);
        order.setCreateTime(null);
        if(order.getOrderStatus()==4){
            //取消订单,需要优化，减少数据库查询次数
            Order o=orderMapper.selectById(order.getId());
            if(o.getOrderStatus()!=0){
                return false;
            }
            IdleItem idleItemModel=idleItemMapper.selectById(o.getIdleId());
            if(idleItemModel.getIdleStatus()==2){
                IdleItem idleItem=new IdleItem();
                idleItem.setId(o.getIdleId());
                idleItem.setUserId(idleItemModel.getUserId());
                idleItem.setIdleStatus((byte)1);
                if(orderMapper.updateById(order)==1){
                    if(idleItemMapper.updateById(idleItem)==1){
                        return true;
                    }else {
                        new RuntimeException();
                    }
                }
                return false;
            }else{
                if(orderMapper.updateById(order)==1){
                    return true;
                }else {
                    new RuntimeException();
                }
            }
        }
        return orderMapper.updateById(order)==1;
    }

    public PageVo<OrderDto> buildOrderDtoListPageVo(QueryWrapper<Order> orderQueryWrapper, Integer page, Integer size){
        int count = orderMapper.selectCount(orderQueryWrapper);
        orderQueryWrapper.last("limit " + (page - 1) * size + "," + size);
        List<Order> orderList = orderMapper.selectList(orderQueryWrapper);

        List<OrderDto> orderDtoList = buildOrderDtoList(orderList);

        return new PageVo<>(orderDtoList,count);
    }

    public List<OrderDto> buildOrderDtoList(List<Order> orderList){
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            orderDtoList.add(buildOrderDto(order));
        }
        return orderDtoList;
    }

    public OrderDto buildOrderDto(Order order){
        QueryWrapper<IdleItem> idleItemQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        return buildOrderDto(order, idleItemQueryWrapper,userQueryWrapper);
    }

    public OrderDto buildOrderDto(Order order, QueryWrapper<IdleItem> idleItemQueryWrapper, QueryWrapper<User> userQueryWrapper){
        idleItemQueryWrapper.eq("id", order.getIdleId());
        IdleItem idleItem = idleItemMapper.selectOne(idleItemQueryWrapper);
        IdleItemDto idleItemDto = idleItem.toDto();
        userQueryWrapper.eq("id", order.getUserId());
        User user = userMapper.selectOne(userQueryWrapper);
        user.setUserPassword(null);
        idleItemDto.setUser(user);
        OrderDto orderDto = order.toDto();
        orderDto.setIdleItemDto(idleItemDto);
        orderDto.setUser(user);
        return orderDto;
    }

}
