package com.api.service;

import com.api.model.dto.MessageDto;
import com.api.model.entity.Message;

import java.util.List;

public interface MessageService {
    List<MessageDto> getMyMessage(Long userId);

    MessageDto getMessage(Long id);

    boolean add(Message message);

    List<MessageDto> getAllIdleMessage(Long idleId);

    boolean delete(Long id);
}
