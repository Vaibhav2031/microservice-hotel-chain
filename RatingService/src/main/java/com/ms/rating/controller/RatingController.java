package com.ms.rating.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.rating.entities.Rating;
import com.ms.rating.services.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    public final RatingService ratingService;

    public RatingController(RatingService ratingService){
        this.ratingService = ratingService;
    }

    @PostMapping("/create-rating")
    public ResponseEntity<Rating> createHotel(@RequestBody Rating rating) {
        try {
       
            this.ratingService.createRating(rating);
            return new ResponseEntity<>(rating, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(rating, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-ratings")
    public List<Rating> getRatings() {
        return this.ratingService.getRatings();
    }

    @GetMapping("/get-ratings-by-user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId) {
        return this.ratingService.getRatingsByUserId(userId);
    }

    @GetMapping("/get-ratings-by-hotel/{hotelId}")
    public List<Rating> getRatingsByHotelId(@PathVariable String hotelId) {
        return this.ratingService.getRatingsByHotelId(hotelId);
    }
    
}
