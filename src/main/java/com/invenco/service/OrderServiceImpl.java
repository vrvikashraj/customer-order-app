package com.invenco.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invenco.dto.OrderDto;
import com.invenco.dto.OrderProductRequest;
import com.invenco.dto.OrderRequest;
import com.invenco.entity.Customer;
import com.invenco.entity.Order;
import com.invenco.entity.Product;
import com.invenco.exception.ResourceNotFoundException;
import com.invenco.repository.CustomerRepository;
import com.invenco.repository.OrderRepository;
import com.invenco.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StockManagementService stockManagementService;
	@Autowired
	private ModelMapper mapper;

	@Transactional
	public OrderDto createOrder(OrderRequest request) {
		Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Customer not found with Id: " + request.getCustomerId()));
		stockManagementService.updateProductStock(request.getProducts());
		List<Product> orderedProducts = productRepository.findAllById(
				request.getProducts().stream().map(OrderProductRequest::getProductId).collect(Collectors.toList()));
		productRepository.saveAll(orderedProducts);
		Double totalPrice = orderedProducts.stream().mapToDouble(op -> op.getPrice() * op.getStockQuantity()).sum();
		boolean premium = totalPrice > 500;

		Order order = new Order();
		order.setCustomer(customer);
		order.setProducts(orderedProducts);
		order.setOrderDate(LocalDate.now());
		order.setIsPremiumOrder(premium);
		Order savedOrder = orderRepository.save(order);
		return mapper.map(savedOrder, OrderDto.class);
	}

	@Override
	public List<OrderDto> getOrdersByCustomer(Long customerId, Double minValue) {
		List<Order> orders = orderRepository.findByCustomerId(customerId);
		return orders.stream().map(order -> {
			OrderDto dto = new OrderDto();
			dto.setId(order.getId());
			dto.setOrderDate(order.getOrderDate());
			dto.setIsPremiumOrder(order.getIsPremiumOrder());
			dto.setCustomerId(order.getCustomer().getId());
			List<Long> productIds = order.getProducts() != null
					? order.getProducts().stream().map(Product::getId).collect(Collectors.toList())
					: new ArrayList<>();
			dto.setProductIds(productIds);
			final double totalPrice = order.getProducts() != null ? order.getProducts().stream()
					.filter(p -> p.getPrice() != null).mapToDouble(Product::getPrice).sum() : 0.0;
			dto.setTotalPrice(totalPrice);

			return dto;
		}).filter(dto -> minValue == null || dto.getTotalPrice() >= minValue).collect(Collectors.toList());
	}
}
