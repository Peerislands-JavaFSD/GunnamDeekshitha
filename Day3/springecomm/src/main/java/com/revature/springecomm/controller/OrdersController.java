package com.revature.springecomm.controller;

import com.revature.springecomm.models.Orders;
import com.revature.springecomm.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    @PostMapping
    public Orders create(@RequestBody Orders o){
        return service.create(o);
    }

    @GetMapping
    public List<Orders> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Orders getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Orders update(@PathVariable Long id, @RequestBody Orders o){
        return service.update(id, o);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Order deleted: " + id;
    }
}