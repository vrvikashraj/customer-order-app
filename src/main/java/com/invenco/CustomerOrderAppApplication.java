package com.invenco;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CustomerOrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderAppApplication.class, args);
	}
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
