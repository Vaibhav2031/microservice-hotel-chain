package com.ms.rating.services;

import java.util.List;

import com.ms.rating.entities.Rating;


public interface RatingService {
    
    // create rating

    public Rating createRating(Rating rating);

    //get all ratings

    public List<Rating> getRatings();

    //get rating by userId

    public List<Rating> getRatingsByUserId(String userId);

    //get ratings by hotelId

    public List<Rating> getRatingsByHotelId(String hotelId);
}
