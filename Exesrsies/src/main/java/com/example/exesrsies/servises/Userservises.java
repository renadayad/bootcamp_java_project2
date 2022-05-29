package com.example.exesrsies.servises;


import com.example.exesrsies.model.Product;
import com.example.exesrsies.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Userservises {
    private ArrayList<User> users = new ArrayList();


    //get
    public ArrayList<User> getUser() {

        return users;
    }

    //add
    public boolean addUser(User user) {

        return users.add(user);
    }

    //update
    public boolean updateUser(int index, User user) {
       users.set(index, user);
        return true;
    }

    //deleat
    public boolean dUser(int index) {
        users.remove(index);
        return true;

    }
    public User getUser(String userid){
        for (User user:users) {
            if(user.getId().equals(userid))
                return user;
        }
        return null;
    }
}//end class


