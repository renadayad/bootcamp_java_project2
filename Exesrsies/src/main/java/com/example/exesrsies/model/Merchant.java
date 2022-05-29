package com.example.exesrsies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class Merchant {
    @NotEmpty(message ="id : must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String id;
    @NotEmpty(message ="name: must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private  String name;



}





