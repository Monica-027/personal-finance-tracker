package com.monica.personalfinancetracker.mapper;


import com.monica.personalfinancetracker.dto.ExpenseDTO;
import com.monica.personalfinancetracker.entity.Expense;

public class ExpenseMapper {
	
	public static ExpenseDTO toDTO(Expense expense) {
		ExpenseDTO expenseDTO = new ExpenseDTO();
		
		expenseDTO.setId(expense.getId());
		expenseDTO.setTitle(expense.getTitle());
		expenseDTO.setAmount(expense.getAmount());
		expenseDTO.setDate(expense.getDate());
		
		//getCategory is used because category is accessed through expense Entity
		if(expense.getCategory() != null) {
			expenseDTO.setCategory(CategoryMapper.toDTO(expense.getCategory()));
		}
		
		return expenseDTO;
	}
	
	
	public static Expense toEntity(ExpenseDTO expenseDTO) {
		
		Expense expense = new Expense();
		
		expense.setId(expenseDTO.getId());
		expense.setTitle(expenseDTO.getTitle());
		expense.setAmount(expenseDTO.getAmount());
		expense.setDate(expenseDTO.getDate());
		
		return expense;
	}

}
