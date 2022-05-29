package com.example.exesrsies.servises;


import com.example.exesrsies.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Merchantservises {
    private ArrayList<Merchant> merchants = new ArrayList();

    //private final Productservises productservises;
    //private final Cartservises cartservises;
    private final Userservises userservises;
    //get
    public ArrayList<Merchant> getMerchant() {

        return merchants;
    }

    //add
    public boolean addMerchant(Merchant merchant) {

        return merchants.add(merchant);
    }

    //update
    public boolean updateMerchant(int index, Merchant merchant) {
       merchants.set(index, merchant);
        return true;
    }

    //deleat
    public boolean dMerchant(int index) {
        merchants.remove(index);
        return true;

    }

    public Merchant getMerchant(String merchantid){
        for (Merchant merchant:merchants) {
            if(merchant.getId().equals(merchantid))
                return merchant;
        }
        return null;
    }
    public boolean addProudectToMerchant(String userid ,String merchantid){
        // products.add(productservises.getProudect(productid));
        //products.add(userservises.getUser(userid))
        Merchant merchant=getMerchant(merchantid);
        User user=userservises.getUser(userid);
        Cart cart=null;
        if(merchant==null&&user==null){
            return false;
        }
        merchants.add(merchant);
        return true;
    }

}//end class


