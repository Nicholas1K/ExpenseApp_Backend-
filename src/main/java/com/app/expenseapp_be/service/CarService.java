package com.app.expenseapp_be.service;

import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import com.app.expenseapp_be.model.Car;
import com.app.expenseapp_be.repository.CarRepository;

@Service
public class CarService {
    
    @Autowired
    CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public void deleteCarByDescAndAmo(String desc, String amou) {
        Car temp = carRepository.findByDescriptionAndAmount(desc, amou);
        carRepository.delete(temp);

    }
}
