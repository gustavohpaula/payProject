package com.payproject.domain.order.dto;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO
{
	@NonNull
	private String name;
	@NonNull
	private BigDecimal value;
	@NonNull
	private Long userId;
}
