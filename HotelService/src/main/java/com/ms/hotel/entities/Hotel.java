package com.ms.hotel.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "hotel")
public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;

    private List<Rating> ratings = new ArrayList<>();

    
}
