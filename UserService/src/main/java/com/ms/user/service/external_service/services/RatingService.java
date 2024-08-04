package com.ms.user.service.external_service.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ms.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/api/ratings/create-rating")
    public Rating createRating(Rating rating);

    @PutMapping("/api/ratings/update-rating/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId,Rating rating);

    @DeleteMapping("/api/ratings/delete-rating/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
    
}
