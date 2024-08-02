package com.dbs.interview.spring_boot.controller;

import com.dbs.interview.spring_boot.entity.Customer;
import com.dbs.interview.spring_boot.model.GetNamesRequest;
import com.dbs.interview.spring_boot.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Customer API")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Create a new customer", description = "Create a new customer by providing name and gender")
    @PostMapping("/customer")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @Operation(summary = "Get customer details", description = "Get customer by id")
    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable("id") @Parameter(name = "id", description = "Customer id", example = "UUID") UUID id) {
        return customerService.getCustomerById(id);
    }

    @Operation(summary = "Get all customer names", description = "Return a list of names by providing page, size and sorting")
    @PostMapping("/customer/names")
    @ResponseBody
    public List<String> getCustomerNames(@RequestBody GetNamesRequest getNamesRequest) {
        return customerService.getAllCustomerNamesLambda(getNamesRequest);
    }

    @Operation(summary = "Get all customer names using JPA function", description = "Return a list of names by providing page, size and sorting using JPA function")
    @PostMapping("/customer/namesByJpa")
    @ResponseBody
    public List<String> getCustomerNamesByJpa(@RequestBody GetNamesRequest getNamesRequest) {
        return customerService.getAllCustomerNamesJPA(getNamesRequest);
    }

    @Operation(summary = "Get all customers", description = "Return all customer details")
    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
