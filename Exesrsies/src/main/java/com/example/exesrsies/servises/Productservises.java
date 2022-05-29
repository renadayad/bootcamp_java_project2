package com.example.exesrsies.servises;


import com.example.exesrsies.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Productservises {
    //private final Productservises productservises;
    private final Merchantservises merchantservises;
    private final Userservises userservises;
    private final PurchaseHistoryservises purchaseHistoryservises;


    private ArrayList<Product> products = new ArrayList();


    //get
    public ArrayList<Product> getProduct() {
        return products;
    }

    //add
    public boolean addProduct(Product product) {

        return products.add(product);
    }

    //update
    public boolean updateProduct(int index, Product product) {
        products.set(index, product);
        return true;
    }

    //deleat
    public boolean dProduct(int index) {
        products.remove(index);
        return true;

    }
    public Product getProudect(String proudectid){
        for (Product product:products) {
            if(product.getId().equals(proudectid))
                return product;
        }
        return null;
    }


    public Integer bayProudectWithoutCart(String proudctid,String userid,String merchantid){
        Product product=getProudect(proudctid);
        User user=userservises.getUser(userid);
        Merchant merchant1=merchantservises.getMerchant(merchantid);
MerchantStock merchantStock=null;
PurchaseHistory purchaseHistory=null;
        if(product==null){
            return -1;
        }
        if(user==null){
            return 0;
        }
        if(merchant1==null){
            return 1;
        }

        if(user.getBalance()<product.getPrice()){
            return 2;
        }
   user.setBalance(user.getBalance()-product.getPrice());
        Integer lastStock= merchantStock.getStock();
        merchantStock.setStock(lastStock-1);
        purchaseHistoryservises.addPurchaseHistory(purchaseHistory);
      return 3;
    }

    public Integer bayProudectwithCart(Cart cart) {
        String merchantid=null;
        User user=null;
        Product product=null;
        Merchant merchant=merchantservises.getMerchant(merchantid);
       MerchantStock merchantStock=null;
        PurchaseHistory purchaseHistory=null;
        if(merchant==null){
            return -1;
        }
        if(checkBalence()==null){
            return 0;
        }

       checkBalence();
        user.setBalance(user.getBalance()-product.getPrice());
        Integer lastStock= merchantStock.getStock();
        merchantStock.setStock(lastStock-1);
        purchaseHistoryservises.addPurchaseHistory(purchaseHistory);
        return 1;
    }//end bayProudectwithCart


    public ArrayList<Product> checkBalence(){
        ArrayList ischeck=new ArrayList<>();
        Cart cart=null;
        Product price=null;
        User user=null;
        for(int i=0;i<cart.getProducts().size();i++){
            if(user.getBalance()>price.getPrice())
                ischeck.add(price);
        }
        return null;
    }

    public Integer postCommit(String userid , String productid , Comment comment){
        Product product=getProudect(productid);
        User user=userservises.getUser(userid);
        MerchantStock merchantStock=null;
        if(product==null){
            return -1;
        }
        if(user==null){
            return 0;
        }
        if(merchantStock.getStock()==getOldStock()){
            return 1;
        }
       product.getComment().add(comment);
        return 2;
    }/////////end post commint

public Integer getAllComment(String productid){
    Product product=getProudect(productid);
    if(product==null){
        return -1;
    }
    product.getComment();
    return 0;
}

public Integer gettAllRate(){
    Comment comment =null;
    if(comment.getRate()!=5) {
        return -1;
    }
    else
        return 0;


    }

    public Integer getAllPurchaseHistory(){
    if(purchaseHistoryservises.getPurchaseHistories()==null){
        return -1;}
    else
    purchaseHistoryservises.getPurchaseHistories();
    return 0;
    }
    public Integer getOldStock(){
        MerchantStock merchantStock=null;
        Integer lastStock= merchantStock.getStock();
        merchantStock.setStock(lastStock-1);
        return lastStock;
    }
}

//end class






