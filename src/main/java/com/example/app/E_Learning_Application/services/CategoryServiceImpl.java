package com.example.app.E_Learning_Application.services;

import com.example.app.E_Learning_Application.dtos.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryDto getCategoryById(String id) {
        return null;
    }

    @Override
    public void deleteCategoryById(String id) {

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, String id) {
        return null;
    }

    @Override
    public CategoryDto searchCategoryByTitle(String title) {
        return null;
    }
}
