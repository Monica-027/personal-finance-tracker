package com.monica.personalfinancetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monica.personalfinancetracker.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
