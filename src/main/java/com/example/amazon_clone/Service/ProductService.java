package com.example.amazon_clone.Service;

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
}
