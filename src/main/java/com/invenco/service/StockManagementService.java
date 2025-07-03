package com.invenco.service;

import java.util.List;

import com.invenco.dto.OrderProductRequest;

public interface StockManagementService {
	void updateProductStock(List<OrderProductRequest> orderProducts);
}
