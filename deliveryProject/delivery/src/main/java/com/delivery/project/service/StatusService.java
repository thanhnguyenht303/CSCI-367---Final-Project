package com.delivery.project.service;

import com.delivery.project.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusService extends JpaRepository<Status, Integer> {
    Status findByStatus (String status);
}
