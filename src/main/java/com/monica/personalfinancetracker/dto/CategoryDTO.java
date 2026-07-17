package com.monica.personalfinancetracker.dto;

import jakarta.validation.constraints.NotNull;

public class CategoryDTO {

	@NotNull(message = "Category id is required")
	private long id;
	
	private String name;

	public CategoryDTO() {
	}

	public CategoryDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
