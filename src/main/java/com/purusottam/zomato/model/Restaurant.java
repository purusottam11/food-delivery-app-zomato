package com.purusottam.zomato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String address;
    @Size(min = 6,max = 6)
    private Integer pinCode;
    @Size(min = 10,max = 10)
    private String phoneNumber;
    @Email
    private String email;
    private List<String> imageUrls;
    private Double openTime;
    private Double closeTime;
    private Double averageRating;
    private boolean opened;
    private List<String> deliveredPinCode;
}
