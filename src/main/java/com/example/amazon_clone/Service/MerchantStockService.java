package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.Merchant;
import com.example.amazon_clone.Model.MerchantStock;
import com.example.amazon_clone.Model.Product;
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
            Product p = productService.getProductID(merchantStock.getProductId());
            Merchant m = merchantService.getMerchantID(merchantStock.getMerchantId());


        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equalsIgnoreCase(merchantStock.getId())){
                return false;
            }

        }if(p.getId().equalsIgnoreCase(merchantStock.getProductId()) && m.getId().equalsIgnoreCase(merchantStock.getMerchantId())){
            merchantStocks.add(merchantStock);

        }
       // merchantStocks.add(merchantStock);
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

    public MerchantStock getMerchantId(String merchantId){
        for (int i = 0; i < merchantStocks.size(); i++) {
            MerchantStock s = merchantStocks.get(i);
            if(s.getMerchantId().equalsIgnoreCase(merchantId)){
                return s;
            }
        }
        return null;
    }

//    public String requestRestock(int merchantId, int productId, int requestedStock) {
//        for (MerchantStock stock : merchantStocks) {
//            if (stock.getMerchantId().equals(String.valueOf(merchantId)) && stock.getProductId().equals(String.valueOf(productId))) {
//                stock.setStock(stock.getStock() + requestedStock);
//                return "Restock request processed successfully.";
//            }
//        }
//        return "Merchant or product not found.";
//    }
}

