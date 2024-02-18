package com.payproject.domain.order.services;

import com.payproject.domain.order.dto.ItemDTO;
import com.payproject.domain.order.dto.OrderDTO;
import com.payproject.domain.order.entities.ItemEntity;
import com.payproject.domain.order.entities.OrderEntity;
import com.payproject.domain.order.repositories.OrderRepository;
import com.payproject.domain.user.entities.UserEntity;
import com.payproject.domain.user.services.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
	@Autowired
	private OrderRepository repository;

	@Autowired
	ItemService itemService;

	public OrderEntity createOrder(OrderDTO data) throws Exception
	{
		List<ItemEntity> items = itemService.createItems(data.getItems());
		OrderEntity newOrder = new OrderEntity(data, items);
		this.saveOrder(newOrder);
		return newOrder;
	}


	public void saveOrder(OrderEntity order)
	{
		this.repository.save(order);
	}
}
