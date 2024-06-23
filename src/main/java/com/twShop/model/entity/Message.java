package com.twShop.model.entity;

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
    private User fromU;
    private Long idleId;
    private IdleItem idle;
    private String content;
    private Date createTime;
    private Long toUser;
    private User toU;
    private Long toMessage;
    private Message toM;
    private static final long serialVersionUID = 1L;

}