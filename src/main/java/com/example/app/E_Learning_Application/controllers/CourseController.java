package com.example.app.E_Learning_Application.controllers;

import com.example.app.E_Learning_Application.config.AppConstants;
import com.example.app.E_Learning_Application.dtos.CourseDto;
import com.example.app.E_Learning_Application.dtos.CustomMessage;
import com.example.app.E_Learning_Application.services.CourseService;
import com.example.app.E_Learning_Application.services.FileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/courses")
@Tag(name = "Courses")
public class CourseController {

    private final CourseService courseService;
    private final FileService fileService;

    public CourseController(CourseService courseService, FileService fileService) {
        this.courseService = courseService;
        this.fileService = fileService;
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<CourseDto> addCourse(@Valid @RequestPart CourseDto courseDto,@RequestParam("file") MultipartFile file) {
        String folder= AppConstants.COURSES_FOLDER_PATH;
        courseDto.setBanner(fileService.uploadImage(file,folder));
        return ResponseEntity.ok(courseService.addCourse(courseDto));
    }

//    @PostMapping("{courseId}/banners")
//    public ResponseEntity<CustomMessage> uploadBanner(@PathVariable UUID courseId,@RequestParam MultipartFile banner) {
//        System.out.println(banner.getOriginalFilename());
//        System.out.println(banner.getName());
//        System.out.println(banner.getSize());
//        System.out.println(banner.getContentType());
//        return ResponseEntity.ok(null);
//    }

    @GetMapping
    public Page<CourseDto> getAllCourses(Pageable pageable) {
        courseService.getAllCourses(pageable);
        return courseService.getAllCourses(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable UUID id) {
        courseService.getCourseById(id);
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomMessage> deleteCourseById(@PathVariable UUID id) {
        courseService.deleteCourseById(id);
        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("Category deleted successfully");
        customMessage.setSuccess(true);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customMessage);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto, @PathVariable UUID id) {
        courseService.updateCourse(courseDto, id);
        return ResponseEntity.ok(courseDto);

    }

//    @GetMapping
//    public ResponseEntity<List<CourseDto> > searchCourse(@RequestParam String keyword) {
//        return ResponseEntity.ok(courseService.searchCourse(keyword));
//    }


}
