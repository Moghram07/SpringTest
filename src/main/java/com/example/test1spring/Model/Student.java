package com.example.test1spring.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "id should not be null")
    private int id;

    @NotNull(message = "name should not be null")
    private String name;

    @NotNull(message = "age should not be null")
    private int age;

    @NotNull(message = "major should not be null")
    private String major;

}
