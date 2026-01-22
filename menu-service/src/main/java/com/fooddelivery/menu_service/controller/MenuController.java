package com.fooddelivery.menu_service.controller;

import com.fooddelivery.menu_service.entity.MenuItem;
import com.fooddelivery.menu_service.entity.Restaurant;
import com.fooddelivery.menu_service.repository.MenuItemRepository;
import com.fooddelivery.menu_service.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor

public class MenuController {
    private final MenuItemRepository menuRepo;
    private final RestaurantRepository restaurantRepo;

    @GetMapping("/{restaurantId}")
    public List<MenuItem> getMenuByRestaurant(@PathVariable Long restaurantId) {
        return menuRepo.findByRestaurantId(restaurantId);
    }

    @PostMapping
    public ResponseEntity<?> addMenuItem(@RequestBody MenuItem menuItem) {
        if (menuItem.getRestaurant() == null || menuItem.getRestaurant().getId() == null) {
            return ResponseEntity.badRequest().body("Restaurant ID is required");
        }

        Restaurant restaurant = restaurantRepo.findById(menuItem.getRestaurant().getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        menuItem.setRestaurant(restaurant);
        return ResponseEntity.ok(menuRepo.save(menuItem));
    }
}
