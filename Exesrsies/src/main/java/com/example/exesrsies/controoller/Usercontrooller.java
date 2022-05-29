package com.example.exesrsies.controoller;

import com.example.exesrsies.model.Product;
import com.example.exesrsies.model.RequestApi;
import com.example.exesrsies.model.User;
import com.example.exesrsies.servises.Productservises;
import com.example.exesrsies.servises.Userservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class Usercontrooller {
    private final Userservises userservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser() {

        return ResponseEntity.status(200).body(userservises.getUser());

    }

    //post
    @PostMapping
    public ResponseEntity<RequestApi> addUser(@RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = userservises.addUser(user);
        if (!ischeck) {
            return ResponseEntity.status(500).body(new RequestApi("Error adding a User", 500));

        }
        return ResponseEntity.status(200).body(new RequestApi("New User added", 200));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody User user ,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new RequestApi(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean ischeck = userservises.updateUser(id,user);
        if (!ischeck) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
        }
        return ResponseEntity.status(201).body(new RequestApi("update Usert", 200));

    }
    //delet
    @DeleteMapping("/{id}")
    public ResponseEntity<RequestApi> delete(@PathVariable Integer id) {
  boolean ischeck=userservises.dUser(id);
   if(!ischeck) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RequestApi("invalid id", 400));
}
        return ResponseEntity.status(201).body(new RequestApi("delete User", 200));

}

}


