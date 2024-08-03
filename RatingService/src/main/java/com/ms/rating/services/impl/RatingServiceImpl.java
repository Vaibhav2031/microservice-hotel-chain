package com.ms.rating.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.rating.entities.Rating;
import com.ms.rating.repositories.RatingRepository;
import com.ms.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return this.ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String ratingId) {
        return this.ratingRepository.findAllByUserId(ratingId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return this.ratingRepository.findAllByHotelId(hotelId);
    }

    
}
