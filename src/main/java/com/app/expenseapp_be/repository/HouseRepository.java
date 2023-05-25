package com.app.expenseapp_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.expenseapp_be.model.House;

public interface HouseRepository extends JpaRepository<House,Long> {
    
    public House findByDescriptionAndAmount(String description, String amount);
}
