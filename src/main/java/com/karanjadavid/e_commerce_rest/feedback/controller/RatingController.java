package com.karanjadavid.e_commerce_rest.feedback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @GetMapping("{productId}")
    public short getProductRating(@PathVariable String productId){
        return 1;
    }

}
