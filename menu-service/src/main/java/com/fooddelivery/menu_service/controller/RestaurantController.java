package com.fooddelivery.menu_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.menu_service.entity.Restaurant;
import com.fooddelivery.menu_service.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    
    private final RestaurantRepository restaurantRepo;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }
}
