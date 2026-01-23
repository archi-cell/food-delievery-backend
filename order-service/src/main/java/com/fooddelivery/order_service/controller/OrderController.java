package com.fooddelivery.order_service.controller;



import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class OrderController {
    private List<Map<String, Object>> pastOrders = new ArrayList<>();

    @PostMapping
    public Map<String, Object> placeOrder(@RequestBody Map<String, Object> order) {
        order.put("status", "Order Placed Successfully!");
        pastOrders.add(order);
        return order;
    }

    @GetMapping
    public List<Map<String, Object>> getPastOrders() {
        return pastOrders;
    }
}
