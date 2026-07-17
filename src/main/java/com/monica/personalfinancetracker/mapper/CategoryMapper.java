package com.monica.personalfinancetracker.mapper;

import com.monica.personalfinancetracker.dto.CategoryDTO;
import com.monica.personalfinancetracker.entity.Category;

public class CategoryMapper {
	
	public static CategoryDTO toDTO(Category category) {
		
		if(category == null) {
			return null;
		}
		CategoryDTO categoryDTO = new CategoryDTO();
		
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		
		return categoryDTO;
	}
	
	public static Category toEntity(CategoryDTO categoryDTO ) {
		
		if(categoryDTO == null) {
			return null;
		}
		Category category = new Category();
		
		category.setID(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		
		return category;
	}
}
