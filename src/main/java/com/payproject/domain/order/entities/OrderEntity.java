package com.payproject.domain.order.entities;

import com.payproject.domain.order.dto.ItemDTO;
import jakarta.persistence.*;
import java.math.BigDecimal;
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
	@OneToMany
	private List<ItemEntity> items;
	private BigDecimal freightValue;
	private BigDecimal discountValue;
}
