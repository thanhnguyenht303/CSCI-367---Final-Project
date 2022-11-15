package com.delivery.project.service;

import com.delivery.project.model.OrderCheckout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCheckoutService extends JpaRepository<OrderCheckout, String> {

}
