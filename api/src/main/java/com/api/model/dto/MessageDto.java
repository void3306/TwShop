package com.api.model.dto;

import com.api.model.entity.IdleItem;
import com.api.model.entity.Message;
import com.api.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto extends Message implements Serializable {
    private User fromUser;
    private IdleItem idle;
    private User toUserEntity;
    private MessageDto toMessageDto;

}
