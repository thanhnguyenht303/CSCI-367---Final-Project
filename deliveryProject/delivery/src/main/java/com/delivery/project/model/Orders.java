package com.delivery.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Entity
@JsonIgnoreProperties({"hybernateLazyInitializer", "handler"})
public class Orders implements Serializable {

    @Id
    private String id;
    private int customerId;
    private Date deliveryTime;
    private int deliveryId;
    private String packageDescription;
    private int pickupId;
    private Date pickupTime;
    private int statusId;

    public Orders (){
    }

    public Orders(String id, int customerId, Date deliveryTime, int deliveryId, String packageDescription, int pickupId, Date pickupTime, int statusId) {
        this.id = id;
        this.customerId = customerId;
        this.deliveryTime = deliveryTime;
        this.deliveryId = deliveryId;
        this.packageDescription = packageDescription;
        this.pickupId = pickupId;
        this.pickupTime = pickupTime;
        this.statusId = statusId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public int getPickupId() {
        return pickupId;
    }

    public void setPickupId(int pickupId) {
        this.pickupId = pickupId;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
