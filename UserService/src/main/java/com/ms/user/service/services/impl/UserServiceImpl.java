package com.ms.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.bouncycastle.asn1.x509.Holder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.user.service.entities.Hotel;
import com.ms.user.service.entities.Rating;
import com.ms.user.service.entities.User;
import com.ms.user.service.exception.UserNotFoundException;
import com.ms.user.service.repositories.UserRepository;
import com.ms.user.service.services.UserService;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        // fetch rating for this user
        Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/api/ratings/get-ratings-by-user/"+user.getUserId(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        logger.info("{}",ratings);

        
        List<Rating> ratingList = ratings.stream().map(rating -> {
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/api/hotels/get-hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        
        user.setRating(ratingList);

        return user;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteUser(String userID) {
        try {
            this.userRepository.deleteById(userID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> updateUser(User user) {
        try {
            this.userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
