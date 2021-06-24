package com.purusottam.zomato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class RestaurantReview {
    @Id
    private String id;
    private String customerId;
    private String restaurantId;
    @Size(max = 150)
    private String review;
    private Double rating;
    private Timestamp timestamp;
    private String imageUrl;
}
