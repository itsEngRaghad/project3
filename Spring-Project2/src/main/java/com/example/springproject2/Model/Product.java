package com.example.springproject2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

//Model
@Data
@AllArgsConstructor

public class Product {


    @NotNull(message = "id can not be null")
    @Min(value = 3,message = "it has to be at least 3 digits")
    private int id;

    @NotEmpty(message = "name can't be empty")
//    @Min(value = 3,message = "it has to be at least 3 characters")
    private String name;

    @NotNull(message = "price can not be null")
    @Positive
    private int price;

    @NotNull(message = "category id can not be null")
    @Min(value = 3,message = "it has to be at least 3 digits")
    private int categoryID;
}
