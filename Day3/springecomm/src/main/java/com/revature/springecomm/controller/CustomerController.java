package com.revature.springecomm.controller;

import com.revature.springecomm.models.Customer;
import com.revature.springecomm.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer create(@RequestBody Customer c){
        return service.create(c);
    }

    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable String id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable String id, @RequestBody Customer c){
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "Customer deleted: " + id;
    }
}