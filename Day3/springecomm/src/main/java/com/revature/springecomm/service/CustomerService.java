package com.revature.springecomm.service;

import com.revature.springecomm.models.Customer;
import com.revature.springecomm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer create(Customer c){
        return repo.save(c);
    }

    public List<Customer> getAll(){
        return repo.findAll();
    }

    public Customer getById(String id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer update(String id, Customer c){
        Customer existing = getById(id);

        existing.setCompanyName(c.getCompanyName());
        existing.setContactName(c.getContactName());
        existing.setCity(c.getCity());
        existing.setCountry(c.getCountry());

        return repo.save(existing);
    }

    public void delete(String id){
        Customer existing = getById(id);
        repo.delete(existing);
    }
}