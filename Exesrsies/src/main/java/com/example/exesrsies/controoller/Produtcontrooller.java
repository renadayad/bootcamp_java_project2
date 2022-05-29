package com.example.exesrsies.controoller;

import com.example.exesrsies.model.*;
import com.example.exesrsies.servises.Productservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class Produtcontrooller {
    private final Productservises productservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<Product>> getProdect() {

        return ResponseEntity.status(200).body(productservises.getProduct());

    }

    //post
    @PostMapping
    public ResponseEntity<RequestApi> addProudect(@RequestBody @Valid Product product, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = productservises.addProduct(product);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding a Proudct", 500));
        }
        return ResponseEntity.status(200).body(new RequestApi("New Proudct added", 200));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Product product ,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = productservises.updateProduct(id,product);
        if (!ischeck) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
        }
        return ResponseEntity.status(201).body(new RequestApi("update Proudect", 200));

    }
    //delet
    @DeleteMapping("/{id}")
    public ResponseEntity<RequestApi> delete(@PathVariable Integer id) {
  boolean ischeck=productservises.dProduct(id);
   if(!ischeck) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
}
        return ResponseEntity.status(201).body(new RequestApi("delet Proudect", 200));

}
@PostMapping("/buyProudectwithoutCart/{userid}/{poudectid}/{merchid}")
    public ResponseEntity<RequestApi> buyProudectwithoutCart(@PathVariable String userid,@PathVariable String poudectid,@PathVariable String merchid){
        Integer buyStatus=productservises.bayProudectWithoutCart(userid,poudectid,merchid);

        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new RequestApi("poudectid is not valid",400));
            case 0:
                return ResponseEntity.status(400).body(new RequestApi("userid is not valid",400));
            case 1:
                return ResponseEntity.status(400).body(new RequestApi("merchid is not valid",400));
            case 2:
                return ResponseEntity.status(200).body(new RequestApi("balence less than price!",400));
            case 3:
                return ResponseEntity.status(200).body(new RequestApi("proudect purchased !",200));
            default:
                return ResponseEntity.status(500).body(new RequestApi("Server error",500));
        }

    }
    @PostMapping("/buyProudecwihthCart")
    public ResponseEntity<RequestApi> buyProudecwihthCart(@ RequestBody Cart cart){
        Integer buyStatus=productservises.bayProudectwithCart(cart);

        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new RequestApi("merchid is not valid",400));
            case 0:
                return ResponseEntity.status(400).body(new RequestApi("balence less than all Proudect",400));
            case 1:
                return ResponseEntity.status(400).body(new RequestApi("add proudect with cart",200));
            default:
                return ResponseEntity.status(500).body(new RequestApi("Server error",500));
        }

    }
    @PutMapping("/getAllCommint/{proudctid}")
    public ResponseEntity<RequestApi> getAllCommint(@PathVariable String proudctid){
        Integer buyStatus=productservises.getAllComment(proudctid);

        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new RequestApi("proudctid is not valid",400));
            case 0:
                return ResponseEntity.status(400).body(new RequestApi("get all commint",200));
            default:
                return ResponseEntity.status(500).body(new RequestApi("Server error",500));
        }

    }

    @PutMapping("/getRate")
    public ResponseEntity<RequestApi> getRate(){
        Integer buyStatus=productservises.gettAllRate();

        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new RequestApi("rate not equal 5",400));
            case 0:
                return ResponseEntity.status(400).body(new RequestApi("rate equal 5",200));
            default:
                return ResponseEntity.status(500).body(new RequestApi("Server error",500));
        }

    }

    @PutMapping("/getPurchaseHistory")
    public ResponseEntity<RequestApi> getPurchaseHistory(){
        Integer buyStatus=productservises.getAllPurchaseHistory();

        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new RequestApi("PurchaseHistory is null",400));
            case 0:
                return ResponseEntity.status(400).body(new RequestApi("get all PurchaseHistory",200));
            default:
                return ResponseEntity.status(500).body(new RequestApi("Server error",500));
        }

    }
@PostMapping("/postcommit/{poudectid}/{userid}")
    public ResponseEntity<RequestApi>postcommit(@PathVariable String poudectid, @PathVariable String userid, @RequestBody Comment comment){

        Integer buyStatus=productservises.postCommit(poudectid,userid,comment);
        switch (buyStatus){
            case -1:
                return ResponseEntity.status(400).body(new RequestApi("poudectid is not valid",400));
            case 0:
                return ResponseEntity.status(400).body(new RequestApi("userid is not valid",400));
            case 1:
                return ResponseEntity.status(400).body(new RequestApi("not bought the product ",400));
            case 2:
                return ResponseEntity.status(200).body(new RequestApi("bought the product !",400));
            default:
                return ResponseEntity.status(500).body(new RequestApi("Server error",500));
        }

    }



}//end class




