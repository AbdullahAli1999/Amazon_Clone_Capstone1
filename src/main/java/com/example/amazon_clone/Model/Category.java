package com.example.amazon_clone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "The id can not be empty")
    private String id;
    @NotEmpty(message = "the name can not be empty")
    @Size(min = 3,message = "Have to be more than 3 length long")
    private String name;
}
