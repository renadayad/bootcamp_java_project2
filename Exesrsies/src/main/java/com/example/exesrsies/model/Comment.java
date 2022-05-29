package com.example.exesrsies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data @AllArgsConstructor
public class Comment {
    @NotEmpty(message ="id : must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String id;
    @NotEmpty(message =" userid: must not be empty" )@Size(min = 5,message ="have to be 5 character long" )
    private  String  userid;
    @NotEmpty(message ="message: must not be empty" )@Size(min = 6,message ="have to be 6 character long" )
    private  String message;
    @NotNull(message = "rate must not be empty")@Size(min = 1,max = 5,message = "must be a number between 1 - 5")
    private  double  rate;

}





