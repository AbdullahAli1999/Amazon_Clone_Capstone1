package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant>merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public boolean addMerchant(Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equalsIgnoreCase(merchant.getId())) {
                return false;
            }
        }
        merchants.add(merchant);
        return true;
    }

    //UPDATE
    public boolean updateMerchant(String id, Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equalsIgnoreCase(merchant.getId())){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }
    //DELETE
    public boolean deleteMerchant(String id){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equalsIgnoreCase(id)){
                merchants.remove(merchants.get(i));
                return true;
            }
        }
        return false;
    }

    public Merchant getMerchantID(String id){
        for (int i = 0; i < merchants.size(); i++) {
            Merchant mid = merchants.get(i);
            if(mid.getId().equalsIgnoreCase(id)){
                return mid;
            }
        }
        return null;
    }

}
