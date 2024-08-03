package com.ms.hotel.services;

import java.util.List;

import com.ms.hotel.entities.Hotel;

public interface HotelService {

    //create hotel
    public Hotel createHotel(Hotel hotel);

    //get hotel details
    public Hotel getHotel(String id);

    //get all hotels
    public List<Hotel> getHotels();
    
}
