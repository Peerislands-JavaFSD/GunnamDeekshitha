package com.revature.springecomm.controller;

import com.revature.springecomm.models.Product;
import com.revature.springecomm.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product p){
        return service.create(p);
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p){
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Product deleted: " + id;
    }
}