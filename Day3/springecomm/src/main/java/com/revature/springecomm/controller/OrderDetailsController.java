package com.revature.springecomm.controller;

import com.revature.springecomm.dto.OrderDetailsRequest;
import com.revature.springecomm.models.OrderDetails;
import com.revature.springecomm.service.OrderDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailsController {

    private final OrderDetailsService service;

    public OrderDetailsController(OrderDetailsService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<OrderDetails> create(@RequestBody OrderDetailsRequest req){
        return ResponseEntity.ok(service.createFromDto(req));
    }


    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> update(@PathVariable Long id, @RequestBody OrderDetails o){
        return ResponseEntity.ok(service.update(id, o));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("OrderDetails deleted: " + id);
    }
}