package com.app.expenseapp_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.expenseapp_be.model.House;
import com.app.expenseapp_be.repository.HouseRepository;
import java.util.List;

@Service
public class HouseService {
    
    @Autowired
    HouseRepository houseRepository;

    public House saveHouse(House house) {
        return houseRepository.save(house);
    }

    public List<House> getAllHouse() {
        return houseRepository.findAll();
    }

    public void deleteHouseByDescAndAmo(String desc, String amou) {
        House temp = houseRepository.findByDescriptionAndAmount(desc, amou);
        houseRepository.delete(temp);
    }
}
