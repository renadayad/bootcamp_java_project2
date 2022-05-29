package com.example.exesrsies.servises;


import com.example.exesrsies.model.Category;
import com.example.exesrsies.model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStocksservises {
    private ArrayList<MerchantStock> merchantStocks = new ArrayList();


    //get
    public ArrayList<MerchantStock> getMerchantStock() {

        return merchantStocks;
    }

    //add
    public boolean addMerchantStock(MerchantStock merchantStock) {

        return merchantStocks.add(merchantStock);
    }

    //update
    public boolean updateMerchantStock(int index, MerchantStock merchantStock) {
        merchantStocks.set(index,merchantStock);
        return true;
    }

    //deleat
    public boolean dMerchantStock(int index) {
       merchantStocks.remove(index);
        return true;

    }
}//end class


