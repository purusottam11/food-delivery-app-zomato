package com.purusottam.zomato.controller;

import com.purusottam.zomato.config.RestaurantDto;
import com.purusottam.zomato.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        try {
            return new ResponseEntity<>(restaurantService.addRestaurant(restaurantDto), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable  String restaurantId,@RequestBody RestaurantDto restaurantDto){
        try {
            return new ResponseEntity<>(restaurantService.updateRestaurant(restaurantId,restaurantDto),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getRestaurant/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable String restaurantId){
        try {
            return new ResponseEntity<>(restaurantService.getRestaurant(restaurantId),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deleteRestaurant/{restaurantId}")
    public ResponseEntity<RestaurantDto> deleteRestaurant(@PathVariable String restaurantId){
        try {
            return new ResponseEntity<>(restaurantService.deleteRestaurant(restaurantId),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getRestaurants")
    public ResponseEntity<List<RestaurantDto>> getRestaurants(){
        try {
            return new ResponseEntity<>(restaurantService.getRestaurants(),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getRestaurants/{pageNumber}/{pageSize}")
    public ResponseEntity<List<RestaurantDto>> getRestaurantByPage(@PathVariable Integer pageNumber,@PathVariable Integer pageSize){
        try {
            return new ResponseEntity<>(restaurantService.getRestaurantsByPageNumber(pageNumber,pageSize),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getRestaurantsByPinCode/{pinCode}")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByPinCode(@PathVariable String pinCode){
        try {
            return new ResponseEntity<>(restaurantService.getRestaurantsByPinCode(pinCode),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
