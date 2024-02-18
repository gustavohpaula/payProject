package com.payproject.payproject.domain.order.dtos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.payproject.domain.order.dto.ItemDTO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemsDTOTests
{

	BigDecimal value = new BigDecimal("10.00");
	@Test
	void shouldCreateAItem()
	{
		ItemDTO item = new ItemDTO("name", new BigDecimal("10.00"), 1L);

		assertThat(item).isNotNull();
	}

	@Test
	void shouldNotCreateAItemWhitoutName()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new ItemDTO(null, value, 1L));
		assertEquals("name is marked non-null but is null", exception.getMessage());
	}

	@Test
	void shouldNotCreateAItemWhitoutValue()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new ItemDTO("name", null, 1L));
		assertEquals("value is marked non-null but is null", exception.getMessage());
	}

	@Test
	void shouldNotCreateAItemWhitoutUserId()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new ItemDTO("name", value, null));
		assertEquals("userId is marked non-null but is null", exception.getMessage());
	}
}
