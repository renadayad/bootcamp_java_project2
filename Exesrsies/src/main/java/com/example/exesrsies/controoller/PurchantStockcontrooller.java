package com.example.exesrsies.controoller;

import com.example.exesrsies.model.Cart;
import com.example.exesrsies.model.Merchant;
import com.example.exesrsies.model.PurchaseHistory;
import com.example.exesrsies.model.RequestApi;
import com.example.exesrsies.servises.Cartservises;
import com.example.exesrsies.servises.PurchaseHistoryservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/purchantstock")
@RequiredArgsConstructor
public class PurchantStockcontrooller {
    private final PurchaseHistoryservises purchaseHistoryservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<PurchaseHistory>> getPurchaseHistory() {

        return ResponseEntity.status(200).body(purchaseHistoryservises.getPurchaseHistories());

    }
@PostMapping
public ResponseEntity<RequestApi> addPurchaseHistory(@RequestBody @Valid PurchaseHistory purchaseHistory, Errors errors) {

    if (errors.hasErrors()) {
        return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
    }
    boolean ischeck = purchaseHistoryservises.addPurchaseHistory(purchaseHistory);
    if (!ischeck) {
        return ResponseEntity.status(500).body(new RequestApi("Error adding aPurchaseHistory", 500));

    }
    return ResponseEntity.status(200).body(new RequestApi("New PurchaseHistory added", 200));
}

}


