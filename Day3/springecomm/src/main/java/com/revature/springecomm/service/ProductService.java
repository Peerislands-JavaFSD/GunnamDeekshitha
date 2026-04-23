package com.revature.springecomm.service;

import com.revature.springecomm.models.Product;
import com.revature.springecomm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product create(Product p){
        return repo.save(p);
    }

    public List<Product> getAll(){
        return repo.findAll();
    }

    public Product getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product update(Long id, Product p){
        Product existing = getById(id);

        existing.setProductName(p.getProductName());
        existing.setUnitPrice(p.getUnitPrice());

        return repo.save(existing);
    }

    public void delete(Long id){
        Product existing = getById(id);
        repo.delete(existing);
    }
}