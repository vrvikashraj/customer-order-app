package com.invenco.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.invenco.dto.ProductDto;
import com.invenco.entity.Product;
import com.invenco.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
    @CacheEvict(value = "products", allEntries = true)
	public ProductDto createProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product savedProduct = productRepository.save(product);
		return modelMapper.map(savedProduct, ProductDto.class);
	}

}
