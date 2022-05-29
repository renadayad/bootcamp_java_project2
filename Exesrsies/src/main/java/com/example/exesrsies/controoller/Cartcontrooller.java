package com.example.exesrsies.controoller;

import com.example.exesrsies.model.*;
import com.example.exesrsies.servises.Cartservises;
import com.example.exesrsies.servises.Userservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class Cartcontrooller {
    private final Cartservises cartservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<Cart>> getCart() {

        return ResponseEntity.status(200).body(cartservises.getCart());

    }

    @PostMapping
    public ResponseEntity<RequestApi> addCart(@RequestBody @Valid Cart cart, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = cartservises.addCart(cart);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding a Cart", 500));
        }
        return ResponseEntity.status(200).body(new RequestApi("New Cart added", 200));
    }

   @PostMapping("/add/{userid}/{prodectid}")
    public ResponseEntity<RequestApi> addProdectToCart(@PathVariable String userid,@PathVariable String prodectid,@RequestBody @Valid Cart cart, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = cartservises.addProudectToCart(userid,prodectid);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding proudct", 500));

        }
        return ResponseEntity.status(200).body(new RequestApi("New proudct added", 200));
    }

  @DeleteMapping("/remove/{userid}/{prodectid}")
    public ResponseEntity<RequestApi> removeProdect(@PathVariable String userid,@PathVariable String prodectid,@RequestBody @Valid Cart cart, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = cartservises.removeProudectFromCart(userid,prodectid);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error removing proudct", 500));

        }
        return ResponseEntity.status(200).body(new RequestApi("removed", 200));
    }
}


