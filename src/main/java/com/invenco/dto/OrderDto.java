package com.invenco.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {
	private Long id;
	private LocalDate orderDate;
	private Boolean isPremiumOrder;
	private Long customerId;
	private List<Long> productIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getIsPremiumOrder() {
		return isPremiumOrder;
	}

	public void setIsPremiumOrder(Boolean isPremiumOrder) {
		this.isPremiumOrder = isPremiumOrder;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

}
