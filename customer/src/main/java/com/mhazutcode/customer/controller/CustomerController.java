package com.mhazutcode.customer.controller;

import com.mhazutcode.customer.dto.CustomerRegistrationRequest;
import com.mhazutcode.customer.model.Customer;
import com.mhazutcode.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController{

    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest){
        log.info("new customer registration {}", customerRequest);
        customerService.save(customerRequest);
    }

    @GetMapping
    public String findAll(){

        log.info("Its inside here and its going very well");

        return "Tadda";
    }

}
