package com.purusottam.zomato.service;

import com.purusottam.zomato.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto addCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(String customerId,CustomerDto customerDto);
    CustomerDto getCustomer(String customerId);
    List<CustomerDto> getCustomers();
    CustomerDto deleteCustomer(String customerId);
    List<CustomerDto> getCustomersByPageNumber(Integer pageNumber,Integer pageSize);
}
