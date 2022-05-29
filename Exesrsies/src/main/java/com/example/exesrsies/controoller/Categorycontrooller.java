package com.example.exesrsies.controoller;

import com.example.exesrsies.model.Category;
import com.example.exesrsies.model.Product;
import com.example.exesrsies.model.RequestApi;
import com.example.exesrsies.servises.Categoryservises;
import com.example.exesrsies.servises.Productservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class Categorycontrooller {
    private final Categoryservises categoryservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategory() {

        return ResponseEntity.status(200).body(categoryservises.getCategory());

    }

    //post
    @PostMapping
    public ResponseEntity<RequestApi> addCategory(@RequestBody @Valid Category category, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = categoryservises.addCategory(category);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding a Category", 500));

        }
        return ResponseEntity.status(200).body(new RequestApi("New Category added", 200));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Category category ,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = categoryservises.updateCategory(id,category);
        if (!ischeck) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
        }
        return ResponseEntity.status(201).body(new RequestApi("update Category", 200));

    }
    //delet
    @DeleteMapping("/{id}")
    public ResponseEntity<RequestApi> delete(@PathVariable Integer id) {
  boolean ischeck=categoryservises.dCategory(id);
   if(!ischeck) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
}
        return ResponseEntity.status(201).body(new RequestApi("delet Proudect", 200));

}

}


