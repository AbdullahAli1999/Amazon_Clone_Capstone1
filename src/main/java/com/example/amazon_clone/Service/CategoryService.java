package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.Category;
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
}
