package com.delivery.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hybernateLazyInitializer", "handler"})
public class OrderCheckout implements Serializable {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String deliveryAddress;
    private Date deliveryTime;
    private String pickupAddress;
    private Date pickupTime;
    private String packageDescription;
    private String status;

    public OrderCheckout(){

    }

    public OrderCheckout(String id, String name, String phoneNumber, String deliveryAddress, Date deliveryTime, String pickupAddress, Date pickupTime, String packageDescription, String status) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTime = deliveryTime;
        this.pickupAddress = pickupAddress;
        this.pickupTime = pickupTime;
        this.packageDescription = packageDescription;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
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

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
