package com.purusottam.zomato.repository;

import com.purusottam.zomato.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    Optional<Customer> findByEmailOrPhoneNumber(String email,String phoneNumber);
}
