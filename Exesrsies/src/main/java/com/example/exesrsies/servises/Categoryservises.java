package com.example.exesrsies.servises;


import com.example.exesrsies.model.Category;
import com.example.exesrsies.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Categoryservises {
    private ArrayList<Category> categories = new ArrayList();


    //get
    public ArrayList<Category> getCategory() {

        return categories;
    }

    //add
    public boolean addCategory(Category category) {

        return categories.add(category);
    }

    //update
    public boolean updateCategory(int index, Category category) {
        categories.set(index, category);
        return true;
    }

    //deleat
    public boolean dCategory(int index) {
        categories.remove(index);
        return true;

    }
}//end class


