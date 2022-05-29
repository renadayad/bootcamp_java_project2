package com.example.exesrsies.servises;


import com.example.exesrsies.model.Cart;
import com.example.exesrsies.model.Product;
import com.example.exesrsies.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Cartservises {
    private final Productservises productservises;
   // private final Cartservises cartservises;
    private final Userservises userservises;
    private ArrayList<Cart> carts = new ArrayList();


    //get
    public ArrayList<Cart> getCart() {

        return carts;
    }
//addproudect



    public boolean addCart(Cart cart){
     return carts.add(cart) ;
    }
    public boolean addProudectToCart(String userid ,String productid){
       // products.add(productservises.getProudect(productid));
        //products.add(userservises.getUser(userid))
        Product product=productservises.getProudect(productid);
        User user=userservises.getUser(userid);
        Cart cart=null;
        if(product==null&&user==null){
            return false;
        }
        cart.getProducts().add(product);
        return true;
    }
    // remove prodect
    public boolean removeProudectFromCart(String userid ,String productid){
        // products.add(productservises.getProudect(productid));
        //products.add(userservises.getUser(userid))
        Product product=productservises.getProudect(productid);
        User user=userservises.getUser(userid);
        Cart cart=null;
        if(product==null&&user==null){
            return false;
        }
        cart.getProducts().clear();

        return true;
    }
          }//end class


