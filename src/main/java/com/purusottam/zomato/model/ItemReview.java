package com.purusottam.zomato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ItemReview {
    @Id
    private String id;
    @Size(max = 150)
    private String review;
    private String userId;
    private String itemId;
    private String restaurantId;
    private double rating;
    private String imageUrl;
}
