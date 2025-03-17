package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.Category;
import com.example.amazon_clone.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    //ADD
    public boolean addCategory(Category category){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId().equalsIgnoreCase(category.getId())){
                return false;
            }
        }
        categories.add(category);
        return true;
    }

    //UPDATE
    public boolean updateCategory(String id,Category category){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId().equalsIgnoreCase(category.getId())){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }

    //DELETE
    public  boolean deleteCategory(String id){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId().equalsIgnoreCase(id)){
                categories.remove(categories.get(i));
                return true;
            }
        }
        return false;
    }

    //SEARCH BY CATEGORY
    public ArrayList<Category> searchByCategory(String name){
        ArrayList<Category> searchByCate = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getName().equalsIgnoreCase(name)){
                searchByCate.add(categories.get(i));
            }
        }
        return searchByCate;
    }

    //
    public Category getCategoryId(String id){
        for (int i = 0; i < categories.size(); i++) {
            Category catId = categories.get(i);
            if(catId.getId().equalsIgnoreCase(id)){
                return catId;
            }
        }
        return null;
    }
}
