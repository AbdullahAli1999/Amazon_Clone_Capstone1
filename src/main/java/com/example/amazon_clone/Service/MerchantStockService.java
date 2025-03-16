package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final ProductService productService;
    private final MerchantService merchantService;
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }
    //ADD
    public boolean addMerchantStock(MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equalsIgnoreCase(merchantStock.getId())){
                return false;
            }
        }
        merchantStocks.add(merchantStock);
        return true;
    }

    //UPDATE
    public boolean updateMerchantStock(String id,MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equalsIgnoreCase(merchantStock.getId())){
                merchantStocks.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }

    //DELETE
    public boolean deleteMerchantStock(String id){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equalsIgnoreCase(id)){
                merchantStocks.remove(merchantStocks.get(i));
                return true;
            }
        }
        return false;

    }

    public boolean addStock(String productId , String merchantId, int add){
        for (int i = 0; i < merchantStocks.size(); i++) {
            MerchantStock stock = merchantStocks.get(i);
            if(stock.getProductId().equals(productId)&& stock.getMerchantId().equals(merchantId)){
                stock.setStock(stock.getStock() + add);
                return true;
            }
        }
        return false;
    }
}
