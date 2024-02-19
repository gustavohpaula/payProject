package com.payproject.domain.order.entities;

import com.payproject.domain.order.dto.OrderDTO;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import lombok.*;

@Entity(name = "orders")
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "order")
	private List<ItemEntity> items;
	private BigDecimal freightValue;
	private BigDecimal discountValue;
	private Date orderDate;

	public OrderEntity(OrderDTO orderDTO, List<ItemEntity> items) throws Exception
	{

		this.items = items;
		this.freightValue = orderDTO.getFreightValue();
		this.discountValue = orderDTO.getDiscountValue();
		this.orderDate = new Date(new java.util.Date().getTime());
	}
}
