package com.api.service.impl;

import com.api.mapper.IdleItemMapper;
import com.api.mapper.MessageMapper;
import com.api.mapper.UserMapper;
import com.api.model.dto.MessageDto;
import com.api.model.entity.IdleItem;
import com.api.model.entity.Message;
import com.api.model.entity.User;
import com.api.model.vo.PageVo;
import com.api.service.MessageService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private IdleItemMapper idleItemMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<MessageDto> getMyMessage(Long userId) {
        QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.eq("user_id", userId);
        return buildMessageDtoList(messageMapper.selectList(messageQueryWrapper));
    }

    @Override
    public MessageDto getMessage(Long id) {
        QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.eq("id", id);
        return buildMessageDto(messageMapper.selectOne(messageQueryWrapper));
    }

    @Override
    public boolean add(Message message) {
        return messageMapper.insert(message) == 1;
    }

    @Override
    public List<MessageDto> getAllIdleMessage(Long idleId) {
        QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.eq("idle_id", idleId);
        return buildMessageDtoList(messageMapper.selectList(messageQueryWrapper));
    }

    @Override
    public boolean delete(Long id) {
        return messageMapper.deleteById(id) == 1;
    }

    public PageVo<MessageDto> buildMessageDtoListPageVo(QueryWrapper<Message> messageQueryWrapper, Integer page, Integer size){
        int count = messageMapper.selectCount(messageQueryWrapper);
        messageQueryWrapper.last("limit "+(page-1)*size+","+size);
        List<Message> messageList = messageMapper.selectList(messageQueryWrapper);
        List<MessageDto> messageDtoList = buildMessageDtoList(messageList);
        return new PageVo<>(messageDtoList,count);
    }

    public List<MessageDto> buildMessageDtoList(List<Message> messageList){
        List<MessageDto> messageDtoList = new ArrayList<>();
        for (Message message : messageList){
            messageDtoList.add(buildMessageDto(message));
        }
        return messageDtoList;
    }

    public MessageDto buildMessageDto(Message message){
        MessageDto messageDto = message.toDto();
        User user = userMapper.selectById(message.getUserId());
        user.setUserPassword(null);
        messageDto.setFromUser(user);
        IdleItem idleItem = idleItemMapper.selectById(message.getIdleId());
        messageDto.setIdle(idleItem);
        Long toMessage = message.getToMessage();
        while (toMessage != null){
            Message toMessageEntity = messageMapper.selectById(toMessage);
            MessageDto dto = toMessageEntity.toDto();
            messageDto.setToMessageDto(dto);
            User userEntity = userMapper.selectById(toMessageEntity.getUserId());
            userEntity.setUserPassword(null);
            messageDto.setToUserEntity(userEntity);
            toMessage = toMessageEntity.getToMessage();
        }
        return messageDto;
    }


}
