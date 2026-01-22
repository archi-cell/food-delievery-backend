package com.fooddelivery.menu_service.repository;

import com.fooddelivery.menu_service.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

    // You can add custom query methods if needed
    // Example: find by restaurant name
    Restaurant findByName(String name);
}
