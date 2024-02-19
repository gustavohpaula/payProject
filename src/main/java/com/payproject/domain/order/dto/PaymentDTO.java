package com.payproject.domain.order.dto;

import com.payproject.domain.order.entities.ItemEntity;
import com.payproject.domain.order.entities.OrderEntity;
import com.payproject.domain.user.entities.UserEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO
{
	private Long orderId;

	private List<PaymentPerUserDTO> paymentList = new ArrayList<>();

	public PaymentDTO getPaymentList(OrderEntity order)
	{
		this.orderId = order.getId();

		List<ItemEntity> items = order.getItems();
		Set<UserEntity> users = items.stream().map(ItemEntity::getUser).collect(Collectors.toSet());



		for (UserEntity user : users)
		{
			BigDecimal paymentValue = new BigDecimal("0.0");
			for (ItemEntity item : items)
			{

				if (item.getUser().getId() == user.getId())
				{
					paymentValue = paymentValue.add(item.getItemValue());
				}
			}
			paymentValue = paymentValue.subtract(
				calculateDiscountValue(users.size(), order.getDiscountValue()));

			paymentValue = paymentValue.add(calculateFreight(users.size(), order.getFreightValue()));
			paymentList.add(
				new PaymentPerUserDTO().getPaymentPerUser(user.getFirstName(), paymentValue));

		}

		return this;
	}

	public BigDecimal calculateDiscountValue(int orderUsers, BigDecimal discountValue)
	{
		return discountValue.divide(BigDecimal.valueOf(orderUsers));
	}

	public BigDecimal calculateFreight(int orderUsers, BigDecimal freightValue)
	{
		return freightValue.divide(BigDecimal.valueOf(orderUsers));
	}

}
