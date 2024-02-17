package com.payproject.domain.order.controller;

import com.payproject.domain.order.dto.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController
{

	@PostMapping("/createOrder")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){


		return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
	}

	@GetMapping("/getOrderHistory")
	public ResponseEntity<String> getOrders(){
		return new ResponseEntity<>("Body", HttpStatus.CREATED);
	}

}
