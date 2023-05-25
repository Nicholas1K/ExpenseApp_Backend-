package com.app.expenseapp_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.expenseapp_be.model.Food;

public interface FoodRepository extends JpaRepository<Food,Long>  {
    
    public Food findByDescriptionAndAmount(String description, String amount);
}
