package com.purusottam.zomato.impl;

import com.purusottam.zomato.config.RestaurantDto;
import com.purusottam.zomato.model.Restaurant;
import com.purusottam.zomato.repository.RestaurantRepository;
import com.purusottam.zomato.service.RestaurantService;
import com.purusottam.zomato.utils.CopyUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        restaurantRepository.findByName(restaurantDto.getName()).ifPresent(
                i ->{
                    throw new RuntimeException("Restaurant is exist ....");
                }
        );
        Restaurant restaurant = new Restaurant();
        CopyUtils.copySafe(restaurantDto,restaurant);
        restaurant = restaurantRepository.save(restaurant);
        CopyUtils.copySafe(restaurant,restaurantDto);
        return restaurantDto;
    }

    @Override
    @Transactional
    public RestaurantDto updateRestaurant(String restaurantId, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                ()-> new RuntimeException("Restaurant not found .... 404"));
        restaurantRepository.findByName(restaurantDto.getName()).ifPresent(
                i ->{
                    throw new RuntimeException("Restaurant Name need to be change ....");
                }
        );
        CopyUtils.copySafe(restaurantDto,restaurant);
        restaurant = restaurantRepository.save(restaurant);
        CopyUtils.copySafe(restaurant,restaurantDto);
        return restaurantDto;
    }

    @Override
    public RestaurantDto getRestaurant(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new RuntimeException("Restaurant not found ... 404"));
        RestaurantDto restaurantDto = new RestaurantDto();
        CopyUtils.copySafe(restaurant,restaurantDto);
        return restaurantDto;
    }

    @Override
    @Transactional
    public RestaurantDto deleteRestaurant(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new RuntimeException("Restaurant not found ... 404"));

        RestaurantDto restaurantDto = new RestaurantDto();
        CopyUtils.copySafe(restaurant,restaurantDto);
        restaurantRepository.deleteById(restaurantId);
        return restaurantDto;
    }

    @Override
    public List<RestaurantDto> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> list = CopyUtils.copySafe(restaurants,RestaurantDto.class);
        return list;
    }

    @Override
    public List<RestaurantDto> getRestaurantsByPageNumber(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        List<Restaurant> restaurants = restaurantRepository.findAll(pageable).getContent();
        List<RestaurantDto> list = CopyUtils.copySafe(restaurants,RestaurantDto.class);
        return list;
    }

    @Override
    public List<RestaurantDto> getRestaurantsByPinCode(String pinCode) {
        List<Restaurant> restaurants = restaurantRepository.findByPinCode(pinCode).get();
        List<RestaurantDto> list = CopyUtils.copySafe(restaurants,RestaurantDto.class);
        return list;
    }

    @Override
    public String checkRestaurantStatus(String restaurantId) {
        return null;
    }
}
