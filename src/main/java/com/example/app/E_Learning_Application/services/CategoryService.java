package com.example.app.E_Learning_Application.services;

import com.example.app.E_Learning_Application.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(String id);

    void deleteCategoryById(String id);

    CategoryDto updateCategory(CategoryDto categoryDto , String id);

    CategoryDto searchCategoryByTitle(String title);




}
