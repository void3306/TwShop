package com.api.model.dto;

import com.api.model.entity.IdleItem;
import com.api.model.entity.Order;
import com.api.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto extends Order implements Serializable {
    private IdleItem idleItem;
    private User user;
}
