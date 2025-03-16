package com.example.amazon_clone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotEmpty(message = "The id can not empty")
    private String id;
    @NotEmpty(message = "The Name can not be empty")
    @Size(min = 3,message = "more than 3 length long")
    private String name;
}
