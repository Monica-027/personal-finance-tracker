package com.monica.personalfinancetracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monica.personalfinancetracker.dto.ExpenseDTO;
import com.monica.personalfinancetracker.entity.Expense;
import com.monica.personalfinancetracker.mapper.ExpenseMapper;
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
    public List<ExpenseDTO> getAllExpenses(){
    	return expenseService.getAllExpenses();
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
