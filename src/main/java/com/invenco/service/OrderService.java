package com.invenco.service;

import java.util.List;

import com.invenco.dto.OrderDto;
import com.invenco.dto.OrderRequest;

public interface OrderService {
	public OrderDto createOrder(OrderRequest request);

	public List<OrderDto> getOrdersByCustomer(Long customerId, Double minValue);
}
