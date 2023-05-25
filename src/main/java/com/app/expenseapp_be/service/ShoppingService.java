package com.app.expenseapp_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.expenseapp_be.model.Shopping;
import com.app.expenseapp_be.repository.ShoppingRepository;
import java.util.List;

@Service
public class ShoppingService {
    
    @Autowired
    ShoppingRepository shoppingRepository;

    public Shopping saveShopping(Shopping shopping) {
        return shoppingRepository.save(shopping);
    }

    public List<Shopping> getAllShopping() {
        return shoppingRepository.findAll();
    }

    public void deleteShoppingByDescAndAmo(String desc, String amou) {
        Shopping temp = shoppingRepository.findByDescriptionAndAmount(desc, amou);
        shoppingRepository.delete(temp);
    }
}
