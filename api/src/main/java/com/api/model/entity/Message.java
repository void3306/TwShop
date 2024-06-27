package com.api.model.entity;

import com.api.model.dto.MessageDto;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@TableName("sh_message")
public class Message implements Serializable {
    private Long id;
    private Long userId;
    private Long idleId;
    private String content;
    private Date createTime;
    private Long toUser;
    private Long toMessage;
    private static final long serialVersionUID = 1L;

    public MessageDto toDto(){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(this.id);
        messageDto.setUserId(this.userId);
        messageDto.setIdleId(this.idleId);
        messageDto.setContent(this.content);
        messageDto.setCreateTime(this.createTime);
        messageDto.setToUser(this.toUser);
        messageDto.setToMessage(this.toMessage);
        return messageDto;
    }
}