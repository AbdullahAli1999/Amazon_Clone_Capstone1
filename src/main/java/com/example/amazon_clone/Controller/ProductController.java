package com.example.amazon_clone.Controller;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.Product;
import com.example.amazon_clone.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getProduct(){
        ArrayList<Product> products = productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }

    //ADD
    @PostMapping("/add")
     public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("add"));
     }

}
