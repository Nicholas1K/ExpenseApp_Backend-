package com.app.expenseapp_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.expenseapp_be.model.ServiceS;

public interface ServiceSRepository extends JpaRepository<ServiceS,Long> {
    
    public ServiceS findByDescriptionAndAmount(String description, String amount);
}
