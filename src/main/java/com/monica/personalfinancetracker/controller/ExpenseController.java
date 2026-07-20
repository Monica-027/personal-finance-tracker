package com.monica.personalfinancetracker.controller;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monica.personalfinancetracker.dto.ExpenseDTO;
import com.monica.personalfinancetracker.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
	
    private final ExpenseService expenseService;	
    
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    
    @PostMapping
    public ExpenseDTO saveExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
    	return expenseService.saveExpense(expenseDTO);
    }
    
   
    @GetMapping
    public Page<ExpenseDTO> getAllExpenses(
    		@RequestParam(defaultValue = "0") int page, 
    		@RequestParam(defaultValue = "5") int size,
    		@RequestParam(defaultValue = "id") String sortBy,
    		@RequestParam(defaultValue = "asc") String direction){
    	return expenseService.getAllExpenses(page, size, sortBy, direction);
    }
    
    @GetMapping("/{id}")
    public ExpenseDTO getExpense(@PathVariable Long id) {
    	return expenseService.getExpense(id);	
    }
    
    @PutMapping("/{id}")
    public ExpenseDTO updateExpense(@PathVariable Long id,@Valid @RequestBody ExpenseDTO expenseDTO) {
    	return expenseService.updateExpense(id, expenseDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
    	 expenseService.deleteExpense(id);
    }

}
