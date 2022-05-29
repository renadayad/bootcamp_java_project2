package com.example.exesrsies.controoller;

import com.example.exesrsies.model.Cart;
import com.example.exesrsies.model.Category;
import com.example.exesrsies.model.Merchant;
import com.example.exesrsies.model.RequestApi;
import com.example.exesrsies.servises.Categoryservises;
import com.example.exesrsies.servises.Merchantservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class Merchantcontrooller {
    private final Merchantservises merchantservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<Merchant>> getMerchant() {

        return ResponseEntity.status(200).body(merchantservises.getMerchant());

    }

    //post
    @PostMapping
    public ResponseEntity<RequestApi> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = merchantservises.addMerchant(merchant);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding a Merchant", 500));

        }
        return ResponseEntity.status(200).body(new RequestApi("New Merchant added", 200));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Merchant merchant ,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = merchantservises.updateMerchant(id,merchant);
        if (!ischeck) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
        }
        return ResponseEntity.status(201).body(new RequestApi("update Merchant", 200));

    }
    //delet
    @DeleteMapping("/{id}")
    public ResponseEntity<RequestApi> delete(@PathVariable Integer id) {
  boolean ischeck=merchantservises.dMerchant(id);
   if(!ischeck) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
}
        return ResponseEntity.status(201).body(new RequestApi("delete Merchant", 200));

}
    @PutMapping("/add/{userid}/{prodectid}")
    public ResponseEntity<RequestApi> addProdectToMerchant(@PathVariable String userid, @PathVariable String prodectid, @RequestBody @Valid Cart cart, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = merchantservises.addProudectToMerchant(userid,prodectid);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding Merchant", 500));

        }
        return ResponseEntity.status(200).body(new RequestApi("New Merchant added", 200));
    }

}


