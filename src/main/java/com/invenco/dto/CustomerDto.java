package com.invenco.dto;

import jakarta.validation.constraints.NotBlank;

public class CustomerDto {
	private Long id;
	private String name;
	@NotBlank(message = "Email must not be blank")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
