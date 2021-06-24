package com.purusottam.zomato.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private String name;
    private String address;
    private Integer pinCode;
    private String phoneNumber;
    private String email;
    private List<String> imageUrls;
    private String openTime;
    private String closeTime;
    private Double averageRating;
    private boolean opened;
    private List<String> deliveredPinCode;
}
