package com.api.service.impl;

import com.api.mapper.MessageMapper;
import com.api.model.dto.MessageDto;
import com.api.model.entity.Message;
import com.api.model.entity.User;
import com.api.model.vo.PageVo;
import com.api.service.MessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<MessageDto> getMyMessage(Long userId) {
        return null;
    }

    public PageVo<MessageDto> buildMessageDtoListPageVo(QueryWrapper<Message> messageQueryWrapper, Integer page, Integer size){
        int count = messageMapper.selectCount(messageQueryWrapper);
        messageQueryWrapper.last("limit " + (page - 1) * size + "," + size);
        List<Message> messageList = messageMapper.selectList(messageQueryWrapper);

        List<MessageDto> messageDtoList = buildMessageDtoList(messageList);

        return new PageVo<>(messageDtoList,count);
    }

    public List<MessageDto> buildMessageDtoList(List<Message> messageList){
        List<MessageDto> messageDtoList = new ArrayList<>();
        for (Message message : messageList) {
            messageDtoList.add(buildMessageDto(message));
        }
        return messageDtoList;
    }

    public MessageDto buildMessageDto(Message message){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> toUserQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> toMessageQueryWrapper = new QueryWrapper<>();
        return null;
    }






}
