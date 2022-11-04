package com.example.demo.service;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Orders;

import java.util.UUID;

public interface OrdersService extends JpaRepository<Orders, UUID> {

}
