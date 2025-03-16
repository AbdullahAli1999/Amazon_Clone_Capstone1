package com.example.amazon_clone.Service;

import com.example.amazon_clone.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
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
}
