package com.delivery.project.api;

import com.delivery.project.model.Address;
import com.delivery.project.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    public Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressService addressService;

    @CrossOrigin
    @RequestMapping(value = "/address/findall", method = RequestMethod.GET)
    public ResponseEntity<List<Address>> listAllAddress (){
        List<Address> addresses = addressService.findAll();
        if(addresses.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
    }

    @RequestMapping(value = "/address/find{id}", method = RequestMethod.GET)
    public Address findAddress (@PathVariable("id") int id) {
        Address address = addressService.findById(id).orElseThrow();
        if(address == null){
            ResponseEntity.notFound().build();
        }
        return address;
    }

    @RequestMapping(value =  "/address/add", method = RequestMethod.POST)
    public Address saveAddress (@Valid @RequestBody Address address) {
        return addressService.save(address);
    }

}
