package com.example.exesrsies.controoller;

import com.example.exesrsies.model.MerchantStock;
import com.example.exesrsies.model.Product;
import com.example.exesrsies.model.RequestApi;
import com.example.exesrsies.servises.MerchantStocksservises;
import com.example.exesrsies.servises.Productservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/mrchantstock")
@RequiredArgsConstructor
public class MerchantStockcontrooller {
    private final MerchantStocksservises merchantStocksservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantStock() {

        return ResponseEntity.status(200).body(merchantStocksservises.getMerchantStock());

    }

    //post
    @PostMapping
    public ResponseEntity<RequestApi> addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = merchantStocksservises.addMerchantStock(merchantStock);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding a MerchantStock", 500));

        }
        return ResponseEntity.status(200).body(new RequestApi("New MerchantStock added", 200));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody MerchantStock merchantStock ,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = merchantStocksservises.updateMerchantStock(id,merchantStock);
        if (!ischeck) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
        }
        return ResponseEntity.status(201).body(new RequestApi("update MerchantStock", 200));

    }
    //delet
    @DeleteMapping("/{id}")
    public ResponseEntity<RequestApi> delete(@PathVariable Integer id) {
  boolean ischeck=merchantStocksservises.dMerchantStock(id);
   if(!ischeck) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
}
        return ResponseEntity.status(201).body(new RequestApi("delete MerchantStock", 200));

}

}


