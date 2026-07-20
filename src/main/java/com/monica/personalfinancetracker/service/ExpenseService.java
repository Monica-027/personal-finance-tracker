package com.monica.personalfinancetracker.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		Expense savedExpense = expenseRepository.save(expense); 
		return ExpenseMapper.toDTO(savedExpense);
	}
	
	public Page<ExpenseDTO> getAllExpenses(int page, int size, String sortBy){
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		
		Page<Expense> expensePage = expenseRepository.findAll(pageable);
		
		return expensePage.map(ExpenseMapper::toDTO);
	}
	
	public ExpenseDTO getExpense(Long id) {
		Expense expense = expenseRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Expense not found with id: " + id));
		return ExpenseMapper.toDTO(expense);
	}
	
	public ExpenseDTO updateExpense(Long id, ExpenseDTO updatedExpenseDTO) {
		
		Expense existingExpense = expenseRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Expense not found with id: " + id));
		
		Category category = categoryRepository.findById(updatedExpenseDTO.getCategory().getId()).orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + id));
		
		existingExpense.setTitle(updatedExpenseDTO.getTitle());
		existingExpense.setAmount(updatedExpenseDTO.getAmount());
		existingExpense.setDate(updatedExpenseDTO.getDate());
		
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
