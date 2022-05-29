package com.example.exesrsies.controoller;

import com.example.exesrsies.model.Cart;
import com.example.exesrsies.model.Comment;
import com.example.exesrsies.servises.Cartservises;
import com.example.exesrsies.servises.Commentservises;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class Commentcontrooller {
    private final Commentservises commentservises;

    //get
    @GetMapping
    public ResponseEntity<ArrayList<Comment>> getComment() {

        return ResponseEntity.status(200).body(commentservises.getComments());

    }


}


