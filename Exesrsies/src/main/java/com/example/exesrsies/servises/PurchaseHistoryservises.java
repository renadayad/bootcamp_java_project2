package com.example.exesrsies.servises;


import com.example.exesrsies.model.Cart;
import com.example.exesrsies.model.Merchant;
import com.example.exesrsies.model.PurchaseHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryservises {
    private ArrayList<PurchaseHistory> purchaseHistories = new ArrayList();


    //get
    public ArrayList<PurchaseHistory> getPurchaseHistories() {

        return purchaseHistories;
    }
    public boolean addPurchaseHistory(PurchaseHistory purchaseHistory) {

        return purchaseHistories.add(purchaseHistory);
    }

    //add

}//end class


