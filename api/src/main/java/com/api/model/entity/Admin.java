package com.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@TableName("sh_admin")
public class Admin implements Serializable {
    private Long id;
    private String accountNumber;
    private String adminPassword;
    private String adminName;
    private static final long serialVersionUID = 1L;
}