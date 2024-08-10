package com.example.app.E_Learning_Application.service;

import com.example.app.E_Learning_Application.dto.CourseDto;
import com.example.app.E_Learning_Application.entity.Course;
import com.example.app.E_Learning_Application.repository.CourseRepository;
import com.example.app.E_Learning_Application.utils.EntityDtoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final EntityDtoMapper entityDtoMapper;
    private ModelMapper modelMapper;
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
        List<Course> courses=courseRepository.findAll();
        List<CourseDto> courseDtoList =courses.stream().map(course -> entityDtoMapper
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

    }

    @Override
    public List<CourseDto> searchCourse(String keyword) {
        return List.of();
    }
}
