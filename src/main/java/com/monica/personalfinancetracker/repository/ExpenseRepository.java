package com.monica.personalfinancetracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.monica.personalfinancetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	Page<Expense> findByCategoryNameIgnoreCase(String categoryName, Pageable pageable);
}
