package com.example.exesrsies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message ="id : must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String id;
    @NotEmpty(message ="productid: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private  String productid;
    @NotEmpty(message ="merchantid: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private  String merchantid;
    @NotNull(message = "stock: must not be empty")@Max(value = 10,message ="have to be more than 10 at start" )
    private int stock;


}





