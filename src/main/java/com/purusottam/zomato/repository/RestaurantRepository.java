package com.purusottam.zomato.repository;

import com.purusottam.zomato.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {
}
