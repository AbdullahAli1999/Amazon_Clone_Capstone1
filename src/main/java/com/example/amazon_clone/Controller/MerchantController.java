package com.example.amazon_clone.Controller;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.Merchant;
import com.example.amazon_clone.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant/")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        ArrayList<Merchant> merchants = merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Added Merchant, Thank you"));
    }
}
