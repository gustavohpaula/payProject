package com.payproject.domain.order.controller;

import com.payproject.domain.order.dto.OrderDTO;
import com.payproject.domain.order.entities.OrderEntity;
import com.payproject.domain.order.services.OrderService;
import com.payproject.domain.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController
{

	@Autowired
	private OrderService orderService;

	@Autowired
	UserService userService;
	@PostMapping("/createOrder")
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDTO orderDTO) throws Exception
	{
		OrderEntity order = orderService.createOrder(orderDTO);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

	@GetMapping("/getOrderHistory")
	public ResponseEntity<String> getOrders(){
		return new ResponseEntity<>("Body", HttpStatus.CREATED);
	}

}
