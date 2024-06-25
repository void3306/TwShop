package com.api.model.dto;

import com.api.model.entity.IdleItem;
import com.api.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdleItemDto extends IdleItem  implements Serializable {
    private User user;

}
