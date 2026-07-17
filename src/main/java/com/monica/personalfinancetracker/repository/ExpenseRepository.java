package com.monica.personalfinancetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monica.personalfinancetracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
