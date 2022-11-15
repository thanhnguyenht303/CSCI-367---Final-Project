package com.delivery.project.service;

import com.delivery.project.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressService extends JpaRepository<Address, Integer> {
    Address findByAddress (String address);
}
