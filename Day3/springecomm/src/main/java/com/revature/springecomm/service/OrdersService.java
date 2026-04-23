package com.revature.springecomm.service;

import com.revature.springecomm.models.Orders;
import com.revature.springecomm.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository repo;

    public OrdersService(OrdersRepository repo) {
        this.repo = repo;
    }

    public Orders create(Orders o){
        return repo.save(o);
    }

    public List<Orders> getAll(){
        return repo.findAll();
    }

    public Orders getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Orders update(Long id, Orders o){
        Orders existing = getById(id);

        existing.setCustomer(o.getCustomer());
        existing.setOrderDate(o.getOrderDate());

        return repo.save(existing);
    }

    public void delete(Long id){
        Orders existing = getById(id);
        repo.delete(existing);
    }
}