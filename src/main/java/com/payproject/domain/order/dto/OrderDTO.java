package com.payproject.domain.order.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO
{

	private List<ItemDTO> items;
	private BigDecimal freightValue;
	private BigDecimal discountValue;
}
