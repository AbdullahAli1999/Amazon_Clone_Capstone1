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

}
