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

import com.app.expenseapp_be.model.Car;
import com.app.expenseapp_be.service.CarService;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class CarController {
    
    @Autowired
    CarService carService;

    @GetMapping("all")
    public ResponseEntity<List<Car>> getAllCarStatistic() {
        return new ResponseEntity<>(carService.getAllCar(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Car> createCarStatistic(@RequestBody Car newCar) {
        return new ResponseEntity<>(carService.saveCar(newCar), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{description}/{amount}")
    public ResponseEntity<String> deleteCarByDescAndAmount(@PathVariable("description") String description,@PathVariable("amount") String amount) {
        carService.deleteCarByDescAndAmo(description, amount);
        return new ResponseEntity<String>("delete successful", HttpStatus.OK);
    }
}
