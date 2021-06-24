package com.purusottam.zomato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Size(min = 10,max = 10)
    private String phoneNumber;
    private String password;
    private boolean active;
}
