package com.ms.user.service.external_service.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.user.service.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    
    @GetMapping("/api/hotels/get-hotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
