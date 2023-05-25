package com.app.expenseapp_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.expenseapp_be.model.Car;


public interface CarRepository extends JpaRepository<Car,Long> {
    
    public Car findByDescriptionAndAmount(String description, String amount);
}
