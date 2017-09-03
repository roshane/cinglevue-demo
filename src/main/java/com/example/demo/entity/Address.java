package com.example.demo.entity;

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
public class Address {

    private String number;
    private String street;
    private String city;
}
