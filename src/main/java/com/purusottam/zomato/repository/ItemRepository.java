package com.purusottam.zomato.repository;

import com.purusottam.zomato.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends MongoRepository<Item,String> {
    Optional<Item> findByRestaurantIdAndItemName(String restaurantId,String itemName);
    Optional<List<Item>> findByRestaurantId(String restaurantId);
}
