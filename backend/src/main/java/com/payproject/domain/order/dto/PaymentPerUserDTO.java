package com.payproject.domain.order.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPerUserDTO
{
	private String userName;
	private BigDecimal paymentValue;
	private String paymentLink;

	public PaymentPerUserDTO getPaymentPerUser(String userName, BigDecimal paymentValue){
		this.userName = userName;
		this.paymentValue = paymentValue;

		return this;
	}
}
