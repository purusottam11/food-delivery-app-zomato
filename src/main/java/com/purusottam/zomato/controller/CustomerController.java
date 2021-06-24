package com.purusottam.zomato.controller;

import com.purusottam.zomato.dto.CustomerDto;
import com.purusottam.zomato.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto){
        try {
            CustomerDto response = customerService.addCustomer(customerDto);
            return new ResponseEntity<>(customerDto, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String customerId, @RequestBody CustomerDto customerDto){
        try {
            CustomerDto response = customerService.updateCustomer(customerId,customerDto);
            return new ResponseEntity<>(customerDto, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String customerId){
        try {
            return new ResponseEntity<>(customerService.getCustomer(customerId),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        try {
            return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable String customerId){
        try {
            return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getCustomers/{pageNumber}/{pageSize}")
    public ResponseEntity<List<CustomerDto>> getCustomers(@PathVariable Integer pageNumber,@PathVariable Integer pageSize){
        try {
            return new ResponseEntity<>(customerService.getCustomersByPageNumber(pageNumber,pageSize),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
