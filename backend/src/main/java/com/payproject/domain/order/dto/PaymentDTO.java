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

	public PaymentDTO getPaymentList(OrderEntity order) {
		this.orderId = order.getId();

		List<ItemEntity> items = order.getItems();
		Set<UserEntity> users = items.stream().map(ItemEntity::getUser).collect(Collectors.toSet());

		for (UserEntity user : users) {
			BigDecimal paymentValue = new BigDecimal("0.0");
			BigDecimal totalValue = new BigDecimal("0.0");

			for (ItemEntity item : items) {
				if (item.getUser().getId() == user.getId()) {
					paymentValue = paymentValue.add(item.getItemValue());
				}
				totalValue = totalValue.add(item.getItemValue());
			}

			BigDecimal proportion = paymentValue.divide(totalValue, 2, BigDecimal.ROUND_HALF_UP);

			BigDecimal deliveryCost = calculateFreight(order, proportion);
			BigDecimal discountAmount = calculateDiscountValue(order, proportion);

			paymentValue = paymentValue.subtract(discountAmount).add(deliveryCost);

			paymentList.add(new PaymentPerUserDTO().getPaymentPerUser(user.getFullName(), paymentValue));
		}

		return this;
	}

	public BigDecimal calculateDiscountValue(OrderEntity order, BigDecimal proportion)
	{
		return order.getDiscountValue().multiply(proportion);
	}

	public BigDecimal calculateFreight(OrderEntity order, BigDecimal proportion)
	{
		return order.getFreightValue().multiply(proportion);
	}

}
