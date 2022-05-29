package com.example.exesrsies.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Product {
    @NotEmpty(message ="id : must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String id;
    @NotEmpty(message ="name: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private  String name;
    @NotNull(message = "price:must not be empty ")@Positive
    private double price;
    @NotEmpty(message ="categoryID: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )

    private String categoryID;
    private ArrayList Comment;

    public Product(String id, String name, double price, String categoryID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryID = categoryID;
        Comment = new ArrayList<>();
    }
}





