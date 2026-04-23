package com.revature.springecomm.repository;

import com.revature.springecomm.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}