package com.ms.hotel.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class StaffController {
    
    @GetMapping("/staffs")
    public List<String> getStaffs() {
        return Arrays.asList("Ram","Sham");
    }
    

}
