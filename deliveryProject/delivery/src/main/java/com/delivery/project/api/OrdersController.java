package com.delivery.project.api;


import com.delivery.project.model.Orders;
import com.delivery.project.service.OrdersService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class OrdersController {
    public Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    OrdersService ordersService;

    @CrossOrigin
    @RequestMapping(value =  "/orders/findall", method = RequestMethod.GET)
    public ResponseEntity<List<Orders>> listAllOrders () {
        List<Orders> orders = ordersService.findAll();
        if(orders.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/find{id}", method = RequestMethod.GET)
    public Orders findOrders (@PathVariable("id") final String id){
        Orders orders = ordersService.findById(id).orElseThrow();
        if(orders == null){
            ResponseEntity.notFound().build();
        }
        return orders;
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public Orders addOrders (@Valid @RequestBody Orders orders) {return ordersService.save(orders);}

    @RequestMapping(value = "/orders/delete{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Orders> deleteOrders (@PathVariable(value = "id") String id){
        Orders orders = ordersService.findById(id).orElseThrow();
        if(orders == null){
            return ResponseEntity.notFound().build();
        }
        ordersService.delete(orders);
        return ResponseEntity.ok().build();
    }
}
