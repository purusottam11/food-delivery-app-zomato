package com.purusottam.zomato.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String itemName;
    private String imageUrl;
    private String restaurantId;
    private Integer quantity;
    private Boolean active;
}
