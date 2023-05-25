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

import com.app.expenseapp_be.model.Shopping;
import com.app.expenseapp_be.service.ShoppingService;

@RestController
@RequestMapping("/api/shopping")
@CrossOrigin
public class ShoppingController {
   
    @Autowired
    ShoppingService shoppingService;

    @GetMapping("all")
    public ResponseEntity<List<Shopping>> getAllShoppingStatistic() {
        return new ResponseEntity<>(shoppingService.getAllShopping(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Shopping> createShoppingStatistic(@RequestBody Shopping newShopping) {
        return new ResponseEntity<>(shoppingService.saveShopping(newShopping), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{description}/{amount}")
    public ResponseEntity<String> deleteShoppingByDescAndAmount(@PathVariable("description") String description,
            @PathVariable("amount") String amount) {
        shoppingService.deleteShoppingByDescAndAmo(description, amount);
        return new ResponseEntity<String>("delete successful", HttpStatus.OK);
    }
}
