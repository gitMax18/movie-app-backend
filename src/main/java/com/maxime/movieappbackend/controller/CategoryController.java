package com.maxime.movieappbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxime.movieappbackend.dto.response.Response;
import com.maxime.movieappbackend.model.Category;
import com.maxime.movieappbackend.service.category.CategoryService;

@RestController
// @CrossOrigin(origins = "*")
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public Response<List<Category>> getAllCategories() {
        return new Response<List<Category>>(HttpStatus.OK.value(), "Retrieved all categories",
                categoryService.getAllCategories());
    }
}
