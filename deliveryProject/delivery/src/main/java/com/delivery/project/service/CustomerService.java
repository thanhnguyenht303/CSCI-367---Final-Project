package com.delivery.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delivery.project.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService extends JpaRepository<Customer, Integer> {
    Customer findByName(String name);
}
