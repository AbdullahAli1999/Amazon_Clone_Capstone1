package com.example.amazon_clone.Controller;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.MerchantStock;
import com.example.amazon_clone.Model.Product;
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
    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable String id, @RequestBody @Valid MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.updateMerchantStock(id, merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("Updated Merchant Stock, Thank you"));
    }

    //DELETE
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id){
        merchantStockService.deleteMerchantStock(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted Merchant Stock, Thank you"));
    }

    //ADD STOCK
    @PutMapping("/addStock/{productId}/{merchantId}/{add}")
    public ResponseEntity addStock(@PathVariable String productId, @PathVariable String merchantId, @PathVariable int add ){
        merchantStockService.addStock(productId,merchantId,add);
        return ResponseEntity.status(200).body(new ApiResponse("Stock updated, thank you"));
    }
}
