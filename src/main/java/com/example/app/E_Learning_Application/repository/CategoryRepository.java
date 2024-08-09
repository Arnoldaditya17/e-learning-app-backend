package com.example.app.E_Learning_Application.repository;

import com.example.app.E_Learning_Application.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
