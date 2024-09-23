package com.example.app.E_Learning_Application.services;

import com.example.app.E_Learning_Application.dtos.CategoryDto;
import com.example.app.E_Learning_Application.dtos.CustomPageResponse;

import java.util.UUID;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CustomPageResponse<CategoryDto> getAllCategories(int pageNumber, int pageSize, String sortBy, String sortOrder);

    CategoryDto getCategoryById(UUID id);

    void deleteCategoryById(UUID id);

    CategoryDto updateCategory(CategoryDto categoryDto , UUID id);

    CategoryDto searchCategoryByTitle(String title);




}
