package com.ms.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{

    List<Rating> findAllByUserId(String userId);

    List<Rating> findAllByHotelId(String hotelId);
    
}
