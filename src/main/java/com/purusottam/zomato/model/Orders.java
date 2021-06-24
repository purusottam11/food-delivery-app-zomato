package com.purusottam.zomato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Orders {
    enum Status{
        ORDER_PLACED,PREPARING,OUT_FO_DELIVERY,DELIVERED;
    }
    @Id
    private String id;
    private String userId;
    private String restaurantId;
    private List<ItemQuantityMapping> items;
    private Instant timestamp;
    private Status status;
    private boolean payment;
}
