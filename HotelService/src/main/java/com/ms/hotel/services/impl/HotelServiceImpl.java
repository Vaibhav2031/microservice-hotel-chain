package com.ms.hotel.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.hotel.entities.Hotel;
import com.ms.hotel.exception.HotelNotFoundException;
import com.ms.hotel.repositories.HotelRepository;
import com.ms.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
       return this.hotelRepository.findById(id).orElseThrow(() ->new HotelNotFoundException("Hotel not found "+id));
    }

    @Override
    public List<Hotel> getHotels() {
        return this.hotelRepository.findAll();
    }

}
