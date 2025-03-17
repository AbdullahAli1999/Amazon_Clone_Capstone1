package com.example.amazon_clone.Service;

import com.example.amazon_clone.Api.ApiResponse;
import com.example.amazon_clone.Model.Category;
import com.example.amazon_clone.Model.Product;
import com.example.amazon_clone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryService categoryService;
   // private final UserService userService;
    ArrayList<Product> products = new ArrayList<>();

    //GET
    public ArrayList<Product> getProducts(){
        return products;
    }

    //ADD
    public boolean addProduct(Product product){

        Category c = categoryService.getCategoryId(product.getCategoryID());
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equalsIgnoreCase(product.getId())) {
                return false;
            }
        }
        if(c.getId().equalsIgnoreCase(product.getCategoryID())){
            products.add(product);
            return true;
        }
//        products.add(product);
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

    public ArrayList<Product> getProductSortedByPrice(){
        ArrayList<Product> sortedProduct = new ArrayList<>(products);
        for (int i = 0; i < sortedProduct.size(); i++) {
            for (int j = i + 1; j < sortedProduct.size(); j++) {
                if(sortedProduct.get(i).getPrice() > sortedProduct.get(j).getPrice()){
                    Product temp = sortedProduct.get(i);
                    sortedProduct.set(i,sortedProduct.get(j));
                    sortedProduct.set(j,temp);
                }

            }

        }
        return sortedProduct;
    }
    public ArrayList<Product> getBestSellers(int bestSeller) {
        ArrayList<Product> bestSellers = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product bestS = products.get(i);
            if(bestS.getBestSeller() >= bestSeller){
                bestSellers.add(bestS);
            }
        }
        return bestSellers;

    }

    public boolean rateProduct(double rateProduct, String pid){
        for (int i = 0; i < products.size(); i++) {
            Product porductRate = products.get(i);
            if(porductRate.getId().equalsIgnoreCase(pid)){
                porductRate.setProductRate(rateProduct);
                return true;
            }
        }
        return false;
    }



    public boolean addComment(String comment, String pid){
        for (int i = 0; i < products.size(); i++) {
            Product productComment = products.get(i);
            if(productComment.getId().equalsIgnoreCase(pid));
            productComment.setComment(comment);
            return true;

        }
        return false;
    }



}
