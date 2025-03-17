package com.example.amazon_clone.Controller;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.Category;
import com.example.amazon_clone.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getCategory(){
        ArrayList<Category> categories = categoryService.getCategories();
        return ResponseEntity.status(200).body(categories);
    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Added category , Thank you"));
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id,@RequestBody @Valid Category category,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.updateCategory(id,category);
        return ResponseEntity.status(200).body(new ApiResponse("Updated category , Thank you"));
    }
    //DELETE
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted Category , Thank you"));
        }


    //SEARCH BY CATEGORY
    @GetMapping("/search/{name}")
    public ResponseEntity searchByCate(@PathVariable String name){
        return ResponseEntity.status(200).body(categoryService.searchByCategory(name));
    }
    }

