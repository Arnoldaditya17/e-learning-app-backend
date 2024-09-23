package com.example.app.E_Learning_Application.controllers;

import com.example.app.E_Learning_Application.config.AppConstants;
import com.example.app.E_Learning_Application.dtos.CategoryDto;
import com.example.app.E_Learning_Application.dtos.CustomMessage;
import com.example.app.E_Learning_Application.dtos.CustomPageResponse;
import com.example.app.E_Learning_Application.services.CategoryService;
import com.example.app.E_Learning_Application.services.FileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final FileService fileService;

    public CategoryController(CategoryService categoryService, FileService fileService) {
        this.categoryService = categoryService;
        this.fileService = fileService;
    }


    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestPart CategoryDto categoryDto, @RequestParam("file") MultipartFile file) {
        String folder=AppConstants.CATEGORIES_FOLDER_PATH;
        categoryDto.setBanner(fileService.uploadImage(file,folder));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDto));
    }


    @GetMapping
    public CustomPageResponse<CategoryDto> getAllCategories(
            @RequestParam(value = "pageNumber", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = AppConstants.DEFAULT_SORT_BY) String sortBy,
            @RequestParam(value = "sortOrder", required = false, defaultValue = AppConstants.DEFAULT_SORT_ORDER) String sortOrder) {
        return categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
    }


    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable UUID id) {
        return categoryService.getCategoryById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CustomMessage> deleteCategoryById(@PathVariable UUID id) {
        categoryService.deleteCategoryById(id);
        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("Category deleted successfully");
        customMessage.setSuccess(true);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customMessage);

    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable UUID id) {
        CategoryDto createdDto = categoryService.updateCategory(categoryDto, id);
        return ResponseEntity.status(HttpStatus.OK
        ).body(createdDto);
    }


}
