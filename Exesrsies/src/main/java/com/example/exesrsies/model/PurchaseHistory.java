package com.example.exesrsies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class PurchaseHistory {
    @NotEmpty(message ="id : must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String id;
    @NotEmpty(message ="userid: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private  String userid;
    @NotEmpty(message ="productid: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String productid;
    @NotNull(message = "price:must not be empty")@Positive
    private double price;



}





