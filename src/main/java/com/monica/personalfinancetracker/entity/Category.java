package com.monica.personalfinancetracker.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Category name is required")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Expense> expenses;

	public Category() {
	}

	public Category(String name, List<Expense> expenses) {
		this.name = name;
		this.expenses = expenses;
	}

	public long getId() {
		return id;
	}
	
	public void setID(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	
	
	
	
	
}
