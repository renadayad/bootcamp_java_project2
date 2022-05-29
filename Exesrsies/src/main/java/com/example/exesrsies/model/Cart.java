package com.example.exesrsies.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Cart {
    @NotEmpty(message ="id : must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String id;
    @NotEmpty(message ="userid: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private  String userid;
    ArrayList <Product>products;

    public Cart(String id, String userid) {
        this.id = id;
        this.userid = userid;
        this.products = new ArrayList<>();
    }
}





