package com.example.app.E_Learning_Application.services;

import com.example.app.E_Learning_Application.dtos.CourseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public interface CourseService {

    CourseDto addCourse(CourseDto courseDto);

    Page<CourseDto> getAllCourses(Pageable pageable);

    CourseDto updateCourse(CourseDto courseDto, UUID id);

    CourseDto getCourseById(UUID id);

    void deleteCourseById(UUID id);

    List<CourseDto> searchCourse(String keyword);





}
