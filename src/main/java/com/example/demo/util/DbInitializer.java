package com.example.demo.util;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by roshane on 9/3/17.
 */
@Component
public class DbInitializer implements CommandLineRunner {

    private final StudentRepository repository;

    private static final Random random = new Random(System.currentTimeMillis());

    private static final Faker faker = new Faker(random);

    DbInitializer(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Student> students = IntStream.range(1, 11)
                .boxed()
                .map(i -> {
                    Student s = new Student();
                    s.setFirstName(faker.name().firstName());
                    s.setLastName(faker.name().lastName());
                    s.setRegNumber("2017CS" + i);
                    Address a = new Address();
                    a.setCity(faker.address().city());
                    a.setNumber(faker.address().buildingNumber());
                    a.setStreet(faker.address().streetName());
                    s.setAddress(a);
                    return s;

                }).collect(Collectors.toList());

        repository.save(students);
    }
}
