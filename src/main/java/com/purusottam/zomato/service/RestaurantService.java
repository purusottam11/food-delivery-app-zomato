package com.purusottam.zomato.service;

import com.purusottam.zomato.config.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    RestaurantDto addRestaurant(RestaurantDto restaurantDto);
    RestaurantDto updateRestaurant(String restaurantId,RestaurantDto restaurantDto);
    RestaurantDto getRestaurant(String restaurantId);
    RestaurantDto deleteRestaurant(String restaurantId);
    List<RestaurantDto> getRestaurants();
    List<RestaurantDto> getRestaurantsByPageNumber(Integer pageNumber,Integer pageSize);
    List<RestaurantDto> getRestaurantsByPinCode(String pinCode);
    String checkRestaurantStatus(String restaurantId);
}
