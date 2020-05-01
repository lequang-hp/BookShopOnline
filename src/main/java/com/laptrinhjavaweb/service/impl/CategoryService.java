package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entitites = categoryRepository.findAll();
		List<CategoryDTO> model = new ArrayList<>();
		for(CategoryEntity item : entitites) {
			CategoryDTO dto = new CategoryDTO();
			dto.setName(item.getName());
			dto.setId(item.getId());
			model.add(dto);
		}
		return model;
	}
}
