package com.example.app.E_Learning_Application.repository;

import com.example.app.E_Learning_Application.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {

}
