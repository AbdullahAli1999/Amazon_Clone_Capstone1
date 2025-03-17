package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.Merchant;
import com.example.amazon_clone.Model.MerchantStock;
import com.example.amazon_clone.Model.Product;
import com.example.amazon_clone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final ProductService productService;
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;
    //private   ArrayList<Product> products = productService.getProducts();
    ArrayList<User> users = new ArrayList<>();

    //GET

    public ArrayList<User> getUsers() {
        return users;
    }

    //ADD
    public boolean addUser(User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equalsIgnoreCase(user.getId())){
                return false;
            }

        }
        users.add(user);
        return true;
    }

    //UPDATE
    public boolean updateUser(String id,User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equalsIgnoreCase(user.getId())){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    //DELETE
    public boolean deleteUser(String id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equalsIgnoreCase(id)){
                users.remove(users.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean buyProudct(String userId , String productId, String merchantId , double take){
            ArrayList<MerchantStock>  merchantStock = merchantStockService.getMerchantStocks();
            Product product = productService.getProductID(productId);
            Merchant merchant = merchantService.getMerchantID(merchantId);
        ArrayList<Product> products = productService.getProducts();
        for (int i = 0; i <users.size() ; i++) {
            User u = users.get(i);
           if(u.getId().equalsIgnoreCase(userId)&& product.getId().equalsIgnoreCase(productId) && merchant.getId().equalsIgnoreCase(merchantId) ){
               for (int j = 0; j <merchantStock.size() ; j++) {
                   MerchantStock m = merchantStock.get(i);
                   if(m.getStock() >= 10 ){
                       m.setStock(m.getStock() - take);
                   }
               }
           }
        }
        for (int i = 0; i < products.size(); i++) {
            Product price = products.get(i);

            for (int j = 0; j < users.size(); j++) {
                User balance = users.get(i);
                if(price.getPrice() < balance.getBalance()){
                    double newbalance =  balance.getBalance() - price.getPrice() ;
                    balance.setBalance(newbalance);
                    return true;
                }
            }
        }
        return false;
    }
}
