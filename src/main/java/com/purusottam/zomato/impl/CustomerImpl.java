package com.purusottam.zomato.impl;

import com.purusottam.zomato.dto.CustomerDto;
import com.purusottam.zomato.model.Customer;
import com.purusottam.zomato.repository.CustomerRepository;
import com.purusottam.zomato.service.CustomerService;
import com.purusottam.zomato.utils.CopyUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        customerRepository.findByEmailOrPhoneNumber(customerDto.getEmail(),customerDto.getPhoneNumber())
                .ifPresent(i ->{
                    throw new RuntimeException("Customer is already Exist ...");
                });
        Customer customer = new Customer();
        CopyUtils.copySafe(customerDto,customer);
        customer =  customerRepository.save(customer);
        CopyUtils.copySafe(customer,customerDto);
        return customerDto;
    }

    @Override
    public CustomerDto updateCustomer(String customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new RuntimeException("Customer not found with the id ... : "+ customerId));
        customerRepository.findByEmailOrPhoneNumber(customerDto.getEmail(),customerDto.getPhoneNumber()).ifPresent(
                i->{
                    throw new RuntimeException("Email id or phone is already Exist ..");
                }
        );
        CopyUtils.copySafe(customerDto,customer);
        customer = customerRepository.save(customer);
        CopyUtils.copySafe(customer,customerDto);
        return customerDto;
    }

    @Override
    public CustomerDto getCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new RuntimeException("Customer not found ... 404 "));
        CustomerDto customerDto = new CustomerDto();
        CopyUtils.copySafe(customer,customerDto);
        return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> list = CopyUtils.copySafe(customers,CustomerDto.class);
        return list;
    }

    @Override
    public CustomerDto deleteCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new RuntimeException("Customer not found ... 404"));
        CustomerDto customerDto = new CustomerDto();
        CopyUtils.copySafe(customer,customerDto);
        customerRepository.deleteById(customerId);
        return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomersByPageNumber(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        List<Customer> customers = customerRepository.findAll(pageable).getContent();
        List<CustomerDto> list = CopyUtils.copySafe(customers,CustomerDto.class);
        return list;
    }
}
