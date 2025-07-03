package com.invenco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.invenco.dto.OrderProductRequest;
import com.invenco.entity.Product;
import com.invenco.exception.ProductOutOfStockException;
import com.invenco.exception.ResourceNotFoundException;
import com.invenco.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class StockManagementServiceImpl implements StockManagementService {
	@Autowired
	private ProductRepository productRepository;

	@Async
	@Transactional
	public void updateProductStock(List<OrderProductRequest> orderProducts) {
		for (OrderProductRequest req : orderProducts) {
			Product product = productRepository.findById(req.getProductId()).orElseThrow(
					() -> new ResourceNotFoundException("Product not found with Id: " + req.getProductId()));

			if (product.getStockQuantity() <= 0 || product.getStockQuantity() < req.getQuantity()) {
				throw new ProductOutOfStockException("Product out of stock: " + product.getProductName());
			}

			product.setStockQuantity(product.getStockQuantity() - req.getQuantity());
		}
		productRepository.flush();
	}
}
