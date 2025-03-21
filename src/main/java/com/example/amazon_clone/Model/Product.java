package com.example.amazon_clone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotEmpty(message = "The id can not empty")
    private String id;
    @NotEmpty(message = "The Name can not be empty")
    @Size(min = 3,message = "more than 3 length long")
    private String name;
    @NotNull(message = "The price can not be empty")
    @Positive
    private double price;
    @NotEmpty(message = "the categoryID can not be empty")
    private String categoryID;
    private int bestSeller;
    //@Min(1)
    @Max(value = 10 , message = "The rete must be 10 or less than 10")
    private double productRate;
    private String comment;
}
