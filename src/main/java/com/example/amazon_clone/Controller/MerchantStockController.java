package com.example.amazon_clone.Controller;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.MerchantStock;
import com.example.amazon_clone.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/ms")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getMercantStock(){
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getMerchantStocks();
        return ResponseEntity.status(200).body(merchantStocks);
    }
    //ADD
    @PostMapping("add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("Added Merchant Stock, Thank you"));
    }
}
