package com.purusottam.zomato.repository;

import com.purusottam.zomato.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {
    Optional<Restaurant> findByName(String restaurantName);
    Optional<List<Restaurant>> findByPinCode(String pinCode);
}
