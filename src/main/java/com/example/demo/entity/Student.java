package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by roshane on 9/3/17.
 */
@Data
@NoArgsConstructor
@Document
public class Student {

    @Id
    @JsonProperty("regNumber")
    private String regNumber;
    private String firstName;
    private String lastName;
    private Address address;

}
