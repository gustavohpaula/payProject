package com.payproject.domain.order.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO
{

	@NonNull
	private List<ItemDTO> items;
	private BigDecimal freightValue;
	private BigDecimal discountValue;
}
