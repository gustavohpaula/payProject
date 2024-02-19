package com.payproject.payproject.domain.order.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import com.payproject.domain.order.dto.PaymentDTO;
import com.payproject.domain.order.entities.ItemEntity;
import com.payproject.domain.order.entities.OrderEntity;
import com.payproject.domain.user.entities.UserEntity;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentDTOTests
{

	BigDecimal value = new BigDecimal("10.00");

	@Test
	public void shoudCreateAPayment()
	{
		UserEntity user = new UserEntity(1L, "first name", "last name", "name@exemple.com", "123456789");
		List<ItemEntity> items = List.of(
			new ItemEntity(1L, "name", new BigDecimal("10.00"), new OrderEntity(), user));
		OrderEntity order = new OrderEntity(1L, items, value, value,
			new Date(new java.util.Date().getTime()));

		assertThat(order).isNotNull();
	}

	@Test
	public void shouldCalculateDiscountValue()
	{
		PaymentDTO paymentDTO = new PaymentDTO();
		BigDecimal discountValue = paymentDTO.calculateDiscountValue(2, value);

		assertThat(discountValue).isEqualTo(new BigDecimal("5.00"));
	}

	@Test
	public void shouldCalculateFreightValue()
	{
		PaymentDTO paymentDTO = new PaymentDTO();
		BigDecimal discountValue = paymentDTO.calculateFreight(2, value);

		assertThat(discountValue).isEqualTo(new BigDecimal("5.00"));
	}
}

