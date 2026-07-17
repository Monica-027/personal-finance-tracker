package com.monica.personalfinancetracker.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Title is required")
	private String title;
	
	@NotNull(message = "Amount is required")
	@Positive(message = "Amount must be greater than zero")
	private BigDecimal amount;
	
	@NotNull(message = "Date is required")
	@PastOrPresent(message = "Date cannot be in the future")
	private LocalDate date;
	
	@ManyToOne
	private Category category;

	public Expense() {
	}

	public Expense(String title, BigDecimal amount, LocalDate date, Category category) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	

}
