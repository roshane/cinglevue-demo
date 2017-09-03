package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by roshane on 9/3/17.
 */
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    List<Student> findAll();

    @Query(value = "{'firstName': {$regex: ?0}}")
    Page<Student> findByFirstNameLike(String name, Pageable p);

    Student findByRegNumber(String regNumber);

    void deleteByRegNumber(String regNumber);
}
