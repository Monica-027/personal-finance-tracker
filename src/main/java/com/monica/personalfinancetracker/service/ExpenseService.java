package com.monica.personalfinancetracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monica.personalfinancetracker.dto.ExpenseDTO;
import com.monica.personalfinancetracker.entity.Category;
import com.monica.personalfinancetracker.entity.Expense;
import com.monica.personalfinancetracker.exception.ResourceNotFoundException;
import com.monica.personalfinancetracker.mapper.ExpenseMapper;
import com.monica.personalfinancetracker.repository.CategoryRepository;
import com.monica.personalfinancetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository ;
	
	private final CategoryRepository categoryRepository;

	public ExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository ) {
		this.expenseRepository = expenseRepository;
		this.categoryRepository = categoryRepository;
	} 	
	
	public ExpenseDTO saveExpense(ExpenseDTO expenseDTO) {
		Expense expense = ExpenseMapper.toEntity(expenseDTO);
		
		Category category = categoryRepository.findById(expenseDTO.getCategory().getId()).orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + expenseDTO.getCategory().getId()));
		expense.setCategory(category);
		Expense savedExpense = expenseRepository.save(expense); //jpa returns saved/persisted entity
		return ExpenseMapper.toDTO(savedExpense);
	}
	
	public List<ExpenseDTO> getAllExpenses(){
		List<Expense> expenses = expenseRepository.findAll();
		
		List<ExpenseDTO> expenseDTOs = new ArrayList<>();
		
		for(Expense exp : expenses) {
			expenseDTOs.add(ExpenseMapper.toDTO(exp));
		}
		
		return expenseDTOs;
	}
	
	public ExpenseDTO getExpense(Long id) {
		Expense expense = expenseRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Expense not found with id: " + id));
		return ExpenseMapper.toDTO(expense);
	}
	
	public ExpenseDTO updateExpense(Long id, ExpenseDTO updatedExpenseDTO) {
		
		Expense existingExpense = expenseRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Expense not found with id: " + id));
		
		//find if the category id added by user is present in db or not
		Category category = categoryRepository.findById(updatedExpenseDTO.getCategory().getId()).orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + id));
		
		existingExpense.setTitle(updatedExpenseDTO.getTitle());
		existingExpense.setAmount(updatedExpenseDTO.getAmount());
		existingExpense.setDate(updatedExpenseDTO.getDate());
		
		//if present attach the category object to expense obj
		existingExpense.setCategory(category);
		
		Expense updatedExpense = expenseRepository.save(existingExpense);
		
		return ExpenseMapper.toDTO(updatedExpense);
	}

	public void deleteExpense(Long id) {
		Expense expense = expenseRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Expense not found with id: " + id));
		
		expenseRepository.delete(expense);
	}
	

}
