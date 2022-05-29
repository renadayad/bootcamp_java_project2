package com.example.exesrsies.servises;


import com.example.exesrsies.model.Cart;
import com.example.exesrsies.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class Commentservises {
    private ArrayList<Comment> comments = new ArrayList();


    //get
    public ArrayList<Comment> getComments() {

        return comments;
    }

    //add

}//end class


