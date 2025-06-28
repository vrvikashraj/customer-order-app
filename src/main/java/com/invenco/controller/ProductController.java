package com.invenco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invenco.dto.ProductDto;
import com.invenco.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<ProductDto> createCustomer(@RequestBody @Valid ProductDto productDto) {
		return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
	}
}
