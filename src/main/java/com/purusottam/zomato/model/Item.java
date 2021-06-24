package com.purusottam.zomato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Item {
    @Id
    private String id;
    private String itemName;
    private String imageUrl;
    private String restaurantId;
    private Integer quantity;
    private boolean active;
}
