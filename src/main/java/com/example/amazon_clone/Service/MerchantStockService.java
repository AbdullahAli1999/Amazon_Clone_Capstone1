package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
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
}
