package com.purusottam.zomato.impl;

import com.purusottam.zomato.config.RestaurantDto;
import com.purusottam.zomato.repository.RestaurantRepository;
import com.purusottam.zomato.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        return null;
    }

    @Override
    public RestaurantDto updateRestaurant(String restaurantId, RestaurantDto restaurantDto) {
        return null;
    }

    @Override
    public RestaurantDto getRestaurant(String restaurantId) {
        return null;
    }

    @Override
    public RestaurantDto deleteRestaurant(String restaurantId) {
        return null;
    }

    @Override
    public List<RestaurantDto> getRestaurants() {
        return null;
    }

    @Override
    public List<RestaurantDto> getRestaurantsByPageNumber(Integer pageNumber, Integer pageSize) {
        return null;
    }

    @Override
    public List<RestaurantDto> getRestaurantsByPinCode(String pinCode) {
        return null;
    }

    @Override
    public String checkRestaurantStatus(String restaurantId) {
        return null;
    }
}
