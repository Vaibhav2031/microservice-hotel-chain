package com.ms.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ms.user.service.entities.Hotel;
import com.ms.user.service.entities.Rating;
import com.ms.user.service.external_service.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	Hotel hotel = new Hotel();

	@Test
	void createRating(){
		Rating rating = Rating.builder().rating(10).userId("").ratingId("1").hotel(hotel).feedback("feedback from feign client").build();
		ratingService.createRating(rating);
		System.out.println("new rating created");
	}

	@Test
	void updateRating() {
		Rating rating = Rating.builder().rating(10).userId("").ratingId("1").hotel(hotel)
				.feedback("feedback from feign client").build();
		ratingService.updateRating("1",rating);
		System.out.println(" rating updated");
	}

}
