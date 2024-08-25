package com.example.app.E_Learning_Application.services;

import com.example.app.E_Learning_Application.dtos.CategoryDto;
import com.example.app.E_Learning_Application.dtos.CustomPageResponse;
import com.example.app.E_Learning_Application.entities.Category;
import com.example.app.E_Learning_Application.exceptions.ResourceNotFoundException;
import com.example.app.E_Learning_Application.repositories.CategoryRepository;
import com.example.app.E_Learning_Application.utils.EntityDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, EntityDtoMapper entityDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    private final EntityDtoMapper entityDtoMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        String catId = UUID.randomUUID().toString();
        categoryDto.setId(catId);
        categoryDto.setCreated_at(new Date());

        //convert dto entity
        Category category = entityDtoMapper.toEntity(categoryDto, Category.class);

        Category savedCategory = categoryRepository.save(category);

        return entityDtoMapper.toDto(savedCategory, CategoryDto.class);

    }

    @Override
    public CustomPageResponse<CategoryDto> getAllCategories(int pageNumber, int pageSize, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        Page<Category> categoryPage = categoryRepository.findAll(pageRequest);
        List<Category> categoryList = categoryPage.getContent();

        List<CategoryDto> categoryDtoList = categoryList.stream().map(category -> entityDtoMapper.toDto(category, CategoryDto.class)).toList();
        CustomPageResponse<CategoryDto> customPageResponse = new CustomPageResponse<>();
        customPageResponse.setPageNumber(pageNumber);
        customPageResponse.setPageSize(pageSize);
        customPageResponse.setLast(categoryPage.isLast());
        customPageResponse.setTotalElements(categoryPage.getTotalElements());
        customPageResponse.setTotalPages(categoryPage.getTotalPages());
        customPageResponse.setContent(categoryDtoList);


        return customPageResponse;
    }

    @Override
    public CategoryDto getCategoryById(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category not found !"));

        return entityDtoMapper.toDto(category, CategoryDto.class);
    }

    @Override
    public void deleteCategoryById(String id) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category not found !"));
        categoryRepository.delete(category);


    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category not found !"));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return entityDtoMapper.toDto(savedCategory, CategoryDto.class);

    }

    @Override
    public CategoryDto searchCategoryByTitle(String title) {
        return null;
    }
}
