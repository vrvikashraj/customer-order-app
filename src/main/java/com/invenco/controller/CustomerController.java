package com.invenco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invenco.dto.CustomerDto;
import com.invenco.service.CustomerService;

import jakarta.validation.Valid;


@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
		return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
	}
}
