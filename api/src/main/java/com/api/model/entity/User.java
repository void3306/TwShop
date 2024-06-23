package com.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@TableName("sh_user")
public class User implements Serializable {
    private Long id;
    private String accountNumber;
    private String userPassword;
    private String nickname;
    private String avatar;
    private Date signInTime;
    private Byte userStatus;
    private static final long serialVersionUID = 1L;
}