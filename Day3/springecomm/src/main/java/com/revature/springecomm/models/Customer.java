package com.revature.springecomm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Schema(description = "Customer entity")
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false, unique = true)
    private String customerId;

    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;

    @Column(name = "contact_name", length = 100)
    private String contactName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Orders> orders;

    public Customer() {
    }

    public Customer(String customerId, String companyName, String contactName, String country, List<Orders> orders, String city) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.country = country;
        this.orders = orders;
        this.city = city;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}