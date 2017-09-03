package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by roshane on 9/3/17.
 */
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    List<Student> findAll();

    List<Student> findByFirstNameLike(@Param("name") String name);

    Student findByRegNumber(@Param("reg") String regNumber);

    void deleteByRegNumber(@Param("reg") String regNumber);
}
