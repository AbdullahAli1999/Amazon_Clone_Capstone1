package com.example.amazon_clone.Service;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    //GET
    public ArrayList<Product> getProducts(){
        return products;
    }

    //ADD
    public boolean addProduct(Product product){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equalsIgnoreCase(product.getId())){
                return false;
            }

        }
        products.add(product);
        return true;
    }

    //UPDATE
    public boolean updateProduct(String id, Product product){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equalsIgnoreCase(product.getId())){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }

    //DELETE
    public boolean deleteProduct(String id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equalsIgnoreCase(id)){
                products.remove(products.get(i));
                return true;
            }
        }
        return false;
    }

    public Product getProductID(String id){
        for (int i = 0; i < products.size(); i++) {
            Product pid = products.get(i);
            if(pid.getId().equalsIgnoreCase(id)){
                return pid;
            }
        }
        return null;
    }
}
