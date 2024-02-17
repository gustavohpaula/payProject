package com.payproject.domain.order.dto;

import com.payproject.domain.user.entities.UserEntity;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO
{
	private String name;
	private BigDecimal value;
	private Long userId;
	private UserEntity user;
}
