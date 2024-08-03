package com.ms.hotel.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ms.hotel.dto.HotelDto;
import com.ms.hotel.entities.Hotel;
import com.ms.hotel.services.HotelService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // create hotel

    @PostMapping("/create-hotel")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        try {
            Hotel hotel = new Hotel();
            hotel.setId(hotelDto.getName().toUpperCase());
            hotel.setName(hotelDto.getName());
            hotel.setLocation(hotelDto.getLocation());
            hotel.setAbout(hotelDto.getAbout());
            this.hotelService.createHotel(hotel);
            return new ResponseEntity<>(hotelDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(hotelDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get all hotels

    @GetMapping("/get-hotels")
    public List<Hotel> getHotels() {
        return this.hotelService.getHotels();
    }

    // get hotel

    @GetMapping("/get-hotel/{id}")
    public Hotel getHotel(@PathVariable String id) {
        return this.hotelService.getHotel(id);
    }
}
