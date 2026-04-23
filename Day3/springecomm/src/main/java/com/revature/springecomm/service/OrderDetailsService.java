package com.revature.springecomm.service;

import com.revature.springecomm.dto.OrderDetailsRequest;
import com.revature.springecomm.models.OrderDetails;
import com.revature.springecomm.models.Orders;
import com.revature.springecomm.models.Product;
import com.revature.springecomm.repository.OrderDetailsRepository;
import com.revature.springecomm.repository.OrdersRepository;
import com.revature.springecomm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository repo;
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;

    // ✅ ONLY ONE constructor
    public OrderDetailsService(OrderDetailsRepository repo,
                               OrdersRepository ordersRepository,
                               ProductRepository productRepository) {
        this.repo = repo;
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
    }

    // ✅ DTO method (IMPORTANT)
    public OrderDetails createFromDto(OrderDetailsRequest req){

        Orders order = ordersRepository.findById(req.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(req.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderDetails od = new OrderDetails();
        od.setOrder(order);
        od.setProduct(product);
        od.setQuantity(req.getQuantity());
        od.setDiscount(req.getDiscount());

        return repo.save(od);
    }

    public List<OrderDetails> getAll(){
        return repo.findAll();
    }

    public OrderDetails getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetails not found"));
    }

    public OrderDetails update(Long id, OrderDetails o){
        OrderDetails existing = getById(id);

        existing.setOrder(o.getOrder());
        existing.setProduct(o.getProduct());
        existing.setQuantity(o.getQuantity());
        existing.setDiscount(o.getDiscount());

        return repo.save(existing);
    }

    public void delete(Long id){
        OrderDetails existing = getById(id);
        repo.delete(existing);
    }
}