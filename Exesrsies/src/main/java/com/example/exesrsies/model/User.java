package com.example.exesrsies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data @AllArgsConstructor
public class User {
    @NotEmpty(message ="id : must not be empty" )@Size(min = 3,message ="have to be 3 character long" )
    private String id;
    @NotEmpty(message ="username: must not be empty" )@Size(min = 5,message ="have to be 5 character long" )
    private  String username;
    @NotEmpty(message ="password: must not be empty" )@Size(min = 6,message ="have to be 6 character long" )
    private  String password;
    @NotEmpty(message ="email: must not be empty" )@Email
    private  String email;
    @NotEmpty(message ="role: must not be empty" ) @Pattern(regexp = ("Admin|Customer"))
    private  String role;
    @NotNull(message = "balance:must not be empty")@Positive
    private  double  balance;

}





