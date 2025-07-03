package com.invenco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invenco.dto.OrderDto;
import com.invenco.dto.OrderRequest;
import com.invenco.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequest request) {
		OrderDto savedOrder = orderService.createOrder(request);
		return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	}

	@GetMapping("/orders/{customerId}")
	public ResponseEntity<List<OrderDto>> getOrdersByCustomer(@PathVariable Long customerId,
			@RequestParam(required = false) Double minValue) {
		return new ResponseEntity<>(orderService.getOrdersByCustomer(customerId, minValue), HttpStatus.OK);
	}
}
