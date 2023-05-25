package com.app.expenseapp_be.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.expenseapp_be.model.Food;
import com.app.expenseapp_be.repository.FoodRepository;
import java.util.List;

@Service
public class FoodService {
   
    @Autowired
    FoodRepository foodRepository;

    public Food saveFood(Food food){
        return foodRepository.save(food);
    }
    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }
    public void deleteFoodByDescAndAmo(String desc, String amou){
        Food temp = foodRepository.findByDescriptionAndAmount(desc, amou);
        foodRepository.delete(temp);
    }
}
