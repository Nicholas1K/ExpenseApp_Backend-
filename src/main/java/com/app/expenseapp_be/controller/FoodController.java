package com.app.expenseapp_be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.expenseapp_be.model.Food;
import com.app.expenseapp_be.service.FoodService;

@RestController
@RequestMapping("/api/food")
@CrossOrigin
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("all")
    public ResponseEntity<List<Food>> getAllFoodStatistic() {
        return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Food> createFoodStatistic(@RequestBody Food newFood){
        return new ResponseEntity<>(foodService.saveFood(newFood),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{description}/{amount}")
    public ResponseEntity<String> deleteFoodByDescAndAmount(@PathVariable("description") String description, @PathVariable("amount") String amount){
        foodService.deleteFoodByDescAndAmo(description, amount);
        return new ResponseEntity<String>("delete successful", HttpStatus.OK);
    }
}
