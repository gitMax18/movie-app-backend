package com.maxime.movieappbackend.service.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.model.Category;
import com.maxime.movieappbackend.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
