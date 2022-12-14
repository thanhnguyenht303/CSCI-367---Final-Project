package com.delivery.project.api;

import com.delivery.project.model.Customer;
import com.delivery.project.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {
    public Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @CrossOrigin
    @RequestMapping(value = "/customer/findall", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomer (){
        List<Customer> customer = customerService.findAll();
        if(customer.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/find{id}", method = RequestMethod.GET)
    public Customer findCustomer (@PathVariable("id") int id){
        Customer customer = customerService.findById(id).orElseThrow();
        if(customer == null){
            ResponseEntity.notFound().build();
        }
        return customer;
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public Customer addCustomer(@Valid @RequestBody Customer customer){
        return customerService.save(customer);
    }

    @RequestMapping(value = "/customer/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer (@PathVariable(value = "id") int customerId,
                                                    @Valid @RequestBody Customer customerForm){
        Customer customer = customerService.findById(customerId).orElseThrow();
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        customer.setName(customerForm.getName());
        customer.setPhoneNumber(customerForm.getPhoneNumber());

        Customer updateCustomer = customerService.save(customer);
        return ResponseEntity.ok(updateCustomer);
    }
}
