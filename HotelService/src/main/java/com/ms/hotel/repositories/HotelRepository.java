package com.ms.hotel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ms.hotel.entities.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String>{
    
}
