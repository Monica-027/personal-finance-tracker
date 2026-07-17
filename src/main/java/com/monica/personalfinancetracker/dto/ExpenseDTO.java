package com.monica.personalfinancetracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class ExpenseDTO {

	private Long id;

	private String title;

	private BigDecimal amount;

	private LocalDate date;

	// Used to validate the nested object
	@Valid
	@NotNull(message = "Category is required")
	private CategoryDTO category;

	public ExpenseDTO() {
	}

	public ExpenseDTO(Long id, String title, BigDecimal amount, LocalDate date, CategoryDTO category) {
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.date = date;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

}
