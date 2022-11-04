package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;
import java.util.Date;
@Entity
@JsonIgnoreProperties({"hybernateLazyInitializer", "handler"})
public class Orders implements Serializable {
    //    private static final UUID serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String customerName;
    private String phoneNumber;
    private Date deliveryTime;
    private String deliveryAddress;
    private String packageDescription;
    private String pickupAddress;
    private Date pickupTime;
    private String status;

    public Orders (){
    }
    public Orders(UUID id, String customerName, String phoneNumber,
                  Date deliveryTime, String deliveryAddress, String packageDescription,
                  String pickupAddress, Date pickupTime, String status) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.packageDescription = packageDescription;
        this.pickupAddress = pickupAddress;
        this.pickupTime = pickupTime;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

