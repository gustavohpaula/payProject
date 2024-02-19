package com.payproject.domain.order.entities;

import com.payproject.domain.order.dto.ItemDTO;
import com.payproject.domain.user.entities.UserEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Entity(name = "items")
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal itemValue;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public ItemEntity(ItemDTO itemDTO, UserEntity user) throws Exception
	{
		this.name = itemDTO.getName();
		this.itemValue = itemDTO.getValue();
		this.user = user;
	}
}
