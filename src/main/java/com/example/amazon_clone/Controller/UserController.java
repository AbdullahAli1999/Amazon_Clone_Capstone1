package com.example.amazon_clone.Controller;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.User;
import com.example.amazon_clone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getUser(){
        ArrayList<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("Added user, Thank u"));
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable String id, @RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("Updated product, Thank you"));

    }

    //DELETE
    @DeleteMapping("del/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted User , Thank you"));
    }

    @PutMapping("/buy/{userId}/{productId}/{merchantId}/{take}")
    public ResponseEntity buyProduct(@PathVariable String productId,@PathVariable String userId, @PathVariable String merchantId,@PathVariable double take){
        userService.buyProudct(userId,productId,merchantId,take);
        return ResponseEntity.status(200).body(new ApiResponse("paid product , thank you"));
    }
    @PutMapping("/dis/{userID}/{productID}/{coupon}")
    public ResponseEntity discountByCoupon(@PathVariable String userID, @PathVariable String productID, @PathVariable double coupon){
        userService.putCoupon(userID,productID,coupon);
        return ResponseEntity.status(200).body(new ApiResponse("Discount completed , Thank you"));
    }
}
