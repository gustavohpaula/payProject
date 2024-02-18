package com.payproject.payproject.domain.order.dtos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.payproject.domain.order.dto.ItemDTO;
import com.payproject.domain.order.dto.OrderDTO;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdersDTOTests
{
	@Test
	void shoudCreateAOrdersDTO()
	{
		List<ItemDTO> items = List.of(new ItemDTO("name", new BigDecimal("10.00"), 1L));
		OrderDTO ordersDTO = new OrderDTO(items, new BigDecimal("10.00"), new BigDecimal("5.00"));

		assertThat(ordersDTO).isNotNull();
	}

	@Test
	void shoudCreateAOrdersDTOWithoutFreight()
	{
		List<ItemDTO> items = List.of(new ItemDTO("name", new BigDecimal("10.00"), 1L));
		OrderDTO ordersDTO = new OrderDTO(items, null, new BigDecimal("5.00"));

		assertThat(ordersDTO).isNotNull();
	}

	@Test
	void shoudCreateAOrdersDTOWithoutDiscount()
	{
		List<ItemDTO> items = List.of(new ItemDTO("name", new BigDecimal("10.00"), 1L));
		OrderDTO ordersDTO = new OrderDTO(items, new BigDecimal("10.00"), null);

		assertThat(ordersDTO).isNotNull();
	}

	@Test
	void shoudNotCreateAOrdersDTOWithoutItems()
	{

		Exception exception = assertThrows(NullPointerException.class,
			() -> new OrderDTO(null, new BigDecimal("10.00"), new BigDecimal("10.00")));
		assertEquals("items is marked non-null but is null", exception.getMessage());
	}
}
