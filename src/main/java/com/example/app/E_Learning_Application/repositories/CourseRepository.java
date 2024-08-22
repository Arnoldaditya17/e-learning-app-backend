package com.example.app.E_Learning_Application.repositories;



import com.example.app.E_Learning_Application.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {




}
