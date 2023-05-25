package com.app.expenseapp_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.expenseapp_be.model.Shopping;

public interface ShoppingRepository extends JpaRepository<Shopping,Long> {
    
    public Shopping findByDescriptionAndAmount(String description, String amount);
}
