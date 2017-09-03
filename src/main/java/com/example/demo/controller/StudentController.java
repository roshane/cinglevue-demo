package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.util.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by roshane on 9/3/17.
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<?>> findAll(@RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageRequest = new PageRequest(page, Integer.MAX_VALUE);
        Page<Student> students = repository.findAll(pageRequest);
        return new ApiResponse.Builder<>()
                .withData(students)
                .withStatus(students.getTotalElements() > 0 ? OK : NOT_FOUND)
                .build();
    }

    @GetMapping("/{regNo}")
    public ResponseEntity<ApiResponse<?>> findByRegNo(@PathVariable String regNo) {
        Student student = repository.findByRegNumber(regNo);
        return new ApiResponse.Builder<>()
                .withData(student)
                .withStatus(student != null ? OK : NOT_FOUND)
                .build();
    }

    @GetMapping("/firstNameLike/{name}")
    public ResponseEntity<ApiResponse<?>> findByFirstNameLike(@PathVariable String name,
                                                              @RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageRequest = new PageRequest(page, Integer.MAX_VALUE);
        Page<Student> students = repository.findByFirstNameLike(name, pageRequest);
        return new ApiResponse.Builder<>()
                .withData(students)
                .withStatus(students.getTotalElements() > 0 ? OK : NOT_FOUND)
                .build();
    }

    @DeleteMapping("/{regNo}")
    public ResponseEntity<ApiResponse<?>> deleteByRegNum(@PathVariable String regNo) {
        repository.deleteByRegNumber(regNo);
        return new ApiResponse.Builder<>()
                .withStatus(NO_CONTENT)
                .build();
    }

    @PutMapping("")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody Student student) {
        Student updated = repository.save(student);
        return new ApiResponse.Builder<>()
                .withStatus(CREATED)
                .withData(updated)
                .build();
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> save(@RequestBody Student student) {
        Student updated = repository.save(student);
        return new ApiResponse.Builder<>()
                .withStatus(CREATED)
                .withData(updated)
                .build();
    }

    @GetMapping("/echo")
    public ResponseEntity<?> echo() {
        throw new RuntimeException("error occurred");
    }

}
