package com.delivery.project.api;


import com.delivery.project.model.*;
import com.delivery.project.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class OrderCheckoutController {

    public Logger logger = LoggerFactory.getLogger(OrderCheckoutController.class);

    @Autowired
    OrderCheckoutService orderCheckoutService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;
    @Autowired
    StatusService statusService;

    @CrossOrigin
    @RequestMapping(value = "/ordercheckout/add", method = RequestMethod.POST)
    public ResponseEntity addOrderCheckout (@Valid @RequestBody OrderCheckout orderCheckout){
//
        Customer customer = customerService.findByName(orderCheckout.getName());
        if(customer == null){
            customer = new Customer();
            customer.setName(orderCheckout.getName());
            customer.setPhoneNumber(orderCheckout.getPhoneNumber());
            customerService.save(customer);
        }

        Address deliveryAddress = addressService.findByAddress(orderCheckout.getDeliveryAddress());
        if(deliveryAddress == null){
            deliveryAddress = new Address();
            deliveryAddress.setAddress(orderCheckout.getDeliveryAddress());
            addressService.save(deliveryAddress);
        }

        Address pickupAddress = addressService.findByAddress(orderCheckout.getPickupAddress());
        if(pickupAddress == null){
            pickupAddress = new Address();
            pickupAddress.setAddress(orderCheckout.getPickupAddress());
            addressService.save(pickupAddress);
        }

        Status status = statusService.findByStatus(orderCheckout.getStatus());

        Orders orders = new Orders();
        orders.setId(orderCheckout.getId());
        orders.setCustomerId(customer.getId());
        orders.setDeliveryId(deliveryAddress.getId());
        orders.setDeliveryTime(orderCheckout.getDeliveryTime());
        orders.setPickupId(pickupAddress.getId());
        orders.setPickupTime(orderCheckout.getPickupTime());
        orders.setPackageDescription(orderCheckout.getPackageDescription());
        orders.setStatusId(status.getId());
        ordersService.save(orders);

        return ResponseEntity.ok().build();
    }
}
