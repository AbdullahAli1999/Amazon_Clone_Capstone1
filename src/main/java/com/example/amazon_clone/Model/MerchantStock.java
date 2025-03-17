package com.example.amazon_clone.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "the id can not be empty")
    private String id;
    @NotEmpty(message = "the product id can not be empty")
    private String productId;
    @NotEmpty(message = "the merchant id can not be empty")
    private String merchantId;
    @NotNull(message = "the stock can not be empty")
    //@Size(min = 10,message = "have to be more than 10 at start")
    @Min(value = 10, message = "have to be more than 10 at start")
    private double stock;
    private int requestedStock;

}
