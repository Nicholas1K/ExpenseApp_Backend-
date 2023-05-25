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

import com.app.expenseapp_be.model.House;
import com.app.expenseapp_be.service.HouseService;

@RestController
@RequestMapping("/api/house")
@CrossOrigin
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("all")
    public ResponseEntity<List<House>> getAllHouseStatistic() {
        return new ResponseEntity<>(houseService.getAllHouse(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<House> createHouseStatistic(@RequestBody House newHouse) {
        return new ResponseEntity<>(houseService.saveHouse(newHouse), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{description}/{amount}")
    public ResponseEntity<String> deleteHouseByDescAndAmount(@PathVariable("description") String description,
            @PathVariable("amount") String amount) {
        houseService.deleteHouseByDescAndAmo(description, amount);
        return new ResponseEntity<String>("delete successful", HttpStatus.OK);
    }
    
}
