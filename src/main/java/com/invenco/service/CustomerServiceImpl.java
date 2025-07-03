package com.invenco.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invenco.dto.CustomerDto;
import com.invenco.entity.Customer;
import com.invenco.exception.DuplicateResourceException;
import com.invenco.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		if (customerRepository.existsByEmail(customerDto.getEmail())) {
			throw new DuplicateResourceException("Customer already exists with email : " + customerDto.getEmail());
		}
		Customer customer = mapper.map(customerDto, Customer.class);
		return mapper.map(customerRepository.save(customer), CustomerDto.class);
	}
}
