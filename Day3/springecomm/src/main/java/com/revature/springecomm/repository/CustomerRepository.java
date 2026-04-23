package com.revature.springecomm.repository;

import com.revature.springecomm.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}