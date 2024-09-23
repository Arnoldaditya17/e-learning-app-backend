package com.example.app.E_Learning_Application.services;

import com.example.app.E_Learning_Application.dtos.CourseDto;
import com.example.app.E_Learning_Application.entities.Course;
import com.example.app.E_Learning_Application.exceptions.ResourceNotFoundException;
import com.example.app.E_Learning_Application.repositories.CourseRepository;
import com.example.app.E_Learning_Application.utils.EntityDtoMapper;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private final EntityDtoMapper entityDtoMapper;
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;
    private final FileService fileService;

    public CourseServiceImpl(EntityDtoMapper entityDtoMapper, ModelMapper modelMapper, CourseRepository courseRepository, FileService fileService) {
        this.entityDtoMapper = entityDtoMapper;
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
        this.fileService = fileService;
    }

    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        courseDto.setCreated_at(new Date());
        Course savedCourse = courseRepository.save(entityDtoMapper.toEntity(courseDto, Course.class));
        return entityDtoMapper.toDto(savedCourse, CourseDto.class);
    }

    @Override
    @Cacheable(value = "allCoursesCache", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<CourseDto> getAllCourses(Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        List<CourseDto> dtos = courses.getContent().stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
        return new PageImpl<>(dtos, pageable, courses.getTotalElements());
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto, UUID id) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        courseDto.setUpdated_at(new Date());
        //this will avoid the model mapper to overwrite
        // the not null fields to be null when updating the course entity
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(courseDto, existingCourse);
        Course savedCourse = courseRepository.save(existingCourse);
        return entityDtoMapper.toDto(savedCourse, CourseDto.class);

    }

    @Override
    public CourseDto getCourseById(UUID id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return entityDtoMapper.toDto(course, CourseDto.class);

    }

    @Override
    public void deleteCourseById(UUID id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("course not found !"));
        courseRepository.delete(course);

    }

    @Override
    public List<CourseDto> searchCourse(String keyword) {
        return List.of();
    }

//    @Override
//    public List<CourseDto> searchCourse(String keyword) {
//        List<Course> courses= courseRepository.findByTitleContainingIgnoreCaseOrShortDescContainingIgnoreCase(keyword,keyword);
//
//        return courses.stream().map(course -> entityDtoMapper.toDto(course, CourseDto.class)).toList();
//    }

}
