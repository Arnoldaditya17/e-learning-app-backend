package com.example.app.E_Learning_Application.service;

import com.example.app.E_Learning_Application.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    CourseDto addCourse(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    CourseDto updateCourse(CourseDto courseDto);

    CourseDto getCourseById(String id);

    void deleteCourseById(String id);

    List<CourseDto> searchCourse(String keyword);





}
