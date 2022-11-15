package com.delivery.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delivery.project.model.Orders;


public interface OrdersService extends JpaRepository<Orders, String> {

}
