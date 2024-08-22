package com.example.app.E_Learning_Application.controllers;

import com.example.app.E_Learning_Application.dtos.CategoryDto;
import com.example.app.E_Learning_Application.dtos.CourseDto;
import com.example.app.E_Learning_Application.repositories.CategoryRepository;
import com.example.app.E_Learning_Application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    CategoryService categoryService;

@PostMapping
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {




}

}
