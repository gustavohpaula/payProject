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

	BigDecimal value = new BigDecimal("10.00");
	@Test
	void shoudCreateAOrdersDTO()
	{
		List<ItemDTO> items = List.of(new ItemDTO("name", value, 1L));
		OrderDTO ordersDTO = new OrderDTO(items, value, value);

		assertThat(ordersDTO).isNotNull();
	}

	@Test
	void shoudCreateAOrdersDTOWithoutFreight()
	{
		List<ItemDTO> items = List.of(new ItemDTO("name", value, 1L));
		OrderDTO ordersDTO = new OrderDTO(items, null, value);

		assertThat(ordersDTO).isNotNull();
	}

	@Test
	void shoudCreateAOrdersDTOWithoutDiscount()
	{
		List<ItemDTO> items = List.of(new ItemDTO("name", value,  1L));
		OrderDTO ordersDTO = new OrderDTO(items,value, null);

		assertThat(ordersDTO).isNotNull();
	}

	@Test
	void shoudNotCreateAOrdersDTOWithoutItems()
	{

		Exception exception = assertThrows(NullPointerException.class,
			() -> new OrderDTO(null,value, value));
		assertEquals("items is marked non-null but is null", exception.getMessage());
	}
}
