package com.example.app.E_Learning_Application.services;

import com.example.app.E_Learning_Application.dtos.CourseDto;
import com.example.app.E_Learning_Application.entities.Course;
import com.example.app.E_Learning_Application.exceptions.ResourceNotFoundException;
import com.example.app.E_Learning_Application.repositories.CourseRepository;
import com.example.app.E_Learning_Application.utils.EntityDtoMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final EntityDtoMapper entityDtoMapper;
    private CourseRepository courseRepository;

    public CourseServiceImpl(EntityDtoMapper entityDtoMapper) {
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        Course savedCourse = courseRepository.save(entityDtoMapper.toEntity(courseDto, Course.class));

        return entityDtoMapper.toDto(savedCourse, CourseDto.class);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtoList = courses.stream().map(course -> entityDtoMapper
                        .toDto(course, CourseDto.class))
                .collect(Collectors.toList());
        return courseDtoList;
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {

        return null;
    }

    @Override
    public CourseDto getCourseById(String id) {
        return null;
    }

    @Override
    public void deleteCourseById(String id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(

                        () -> new ResourceNotFoundException("course not found !")
                );
        courseRepository.delete(course);

    }

    @Override
    public List<CourseDto> searchCourse(String keyword) {
        return List.of();
    }
}
