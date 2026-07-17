package com.monica.personalfinancetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.monica.personalfinancetracker.dto.CategoryDTO;
import com.monica.personalfinancetracker.entity.Category;
import com.monica.personalfinancetracker.exception.ResourceNotFoundException;
import com.monica.personalfinancetracker.mapper.CategoryMapper;
import com.monica.personalfinancetracker.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
		
		Category category = CategoryMapper.toEntity(categoryDTO);
		Category savedCategory = categoryRepository.save(category);
		return CategoryMapper.toDTO(savedCategory);
	}
	
	public List<CategoryDTO> getAllCategories(){
		List<Category> categories = categoryRepository.findAll();
		
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for(Category category : categories) {
			categoryDTOs.add(CategoryMapper.toDTO(category));
		}
		return categoryDTOs;
	}
	

	public CategoryDTO getCategory(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + id));
		return CategoryMapper.toDTO(category);
	}
	
	public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {

		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + id));
		
		existingCategory.setName(categoryDTO.getName());
		
		//Response will be persisted entity
		Category updatedCategory = categoryRepository.save(existingCategory);
		
		return CategoryMapper.toDTO(updatedCategory);
	}
	
	public void deleteCategory(Long id) {
		Category category = categoryRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + id));
		
		categoryRepository.delete(category);
	}

}
