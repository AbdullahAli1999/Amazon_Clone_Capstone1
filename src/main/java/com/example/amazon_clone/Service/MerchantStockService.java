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
}
