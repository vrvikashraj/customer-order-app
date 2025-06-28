package com.invenco.dto;

import java.util.List;

public class OrderRequest {
	private Long customerId;
	private List<OrderProductRequest> products;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<OrderProductRequest> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProductRequest> products) {
		this.products = products;
	}

}
