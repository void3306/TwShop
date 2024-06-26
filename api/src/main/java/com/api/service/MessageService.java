package com.api.service;

import com.api.model.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getMyMessage(Long userId);
}
