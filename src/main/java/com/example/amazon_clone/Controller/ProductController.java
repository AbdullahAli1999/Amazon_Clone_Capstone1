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

     //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id,@RequestBody @Valid Product product , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.updateProduct(id, product);
        return ResponseEntity.status(200).body(new ApiResponse("Updated Product, Thank you"));
    }

    //DELETE
    @DeleteMapping("del/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted Product, Thank you"));
    }

    @GetMapping("/products/sortedByPrice")
    public ResponseEntity<ArrayList> getProductSortedByPrice(){
        ArrayList<Product> sortedProducts = productService.getProductSortedByPrice();
        return ResponseEntity.status(200).body(sortedProducts);
    }

    @GetMapping("/best-sellers/{bestSeller}")
    public ResponseEntity<ArrayList<Product>> getBestSellers(@PathVariable int bestSeller) {
        ArrayList<Product> bestSellers = productService.getBestSellers(bestSeller);
        return ResponseEntity.status(200).body(bestSellers);
    }

    @PutMapping("/rate/{pid}/{rate}")
    public ResponseEntity productRate(@PathVariable double rate, @PathVariable String pid){
        if(productService.rateProduct(rate,pid)){
            return ResponseEntity.status(200).body("Great the rate successful");
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

}
