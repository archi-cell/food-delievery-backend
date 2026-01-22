package com.fooddelivery.menu_service.repository;

import com.fooddelivery.menu_service.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {}
