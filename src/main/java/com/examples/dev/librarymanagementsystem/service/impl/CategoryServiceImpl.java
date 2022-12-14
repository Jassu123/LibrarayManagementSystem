package com.examples.dev.librarymanagementsystem.service.impl;

import java.util.List;

import com.examples.dev.librarymanagementsystem.entity.Category;
import com.examples.dev.librarymanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.examples.dev.librarymanagementsystem.exception.NotFoundException;
import com.examples.dev.librarymanagementsystem.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found  with ID %d", id)));
	}

	@Override
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		var category = categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found  with ID %d", id)));

		categoryRepository.deleteById(category.getId());
	}

}
