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

import com.monica.personalfinancetracker.dto.CategoryDTO;
import com.monica.personalfinancetracker.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public CategoryDTO saveCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		return categoryService.saveCategory(categoryDTO);
	}

	@GetMapping
	public List<CategoryDTO> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/{id}")
	public CategoryDTO getCategory(@PathVariable Long id) {
		return categoryService.getCategory(id);
	}

	@PutMapping("/{id}")
	public CategoryDTO updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
		return categoryService.updateCategory(id, categoryDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}
}
