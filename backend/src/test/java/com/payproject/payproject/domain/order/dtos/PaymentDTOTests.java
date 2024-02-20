package com.payproject.payproject.domain.order.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import com.payproject.domain.order.dto.PaymentDTO;
import com.payproject.domain.order.entities.ItemEntity;
import com.payproject.domain.order.entities.OrderEntity;
import com.payproject.domain.user.entities.UserEntity;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentDTOTests
{

	BigDecimal value = new BigDecimal("10.00");

	OrderEntity order;
	@BeforeEach
	void setup(){
		UserEntity user = new UserEntity(1L, "first name", "name@exemple.com", "123456789");
		List<ItemEntity> items = List.of(
			new ItemEntity(1L, "name", value, new OrderEntity(), user));
		order = new OrderEntity(1L, items, value, value,
			new Date(new java.util.Date().getTime()));
	}

	@Test
	public void shoudCreateAPayment()
	{
		assertThat(order).isNotNull();
	}

	@Test
	public void shouldCalculateDiscountValue()
	{
		PaymentDTO paymentDTO = new PaymentDTO();
		BigDecimal discountValue = paymentDTO.calculateDiscountValue(order, new BigDecimal("0.84"));

		assertThat(discountValue).isEqualTo(new BigDecimal("8.4000"));
	}

	@Test
	public void shouldCalculateFreightValue()
	{
		PaymentDTO paymentDTO = new PaymentDTO();
		BigDecimal discountValue = paymentDTO.calculateFreight(order, new BigDecimal("0.84"));

		assertThat(discountValue).isEqualTo(new BigDecimal("8.4000"));
	}
}

