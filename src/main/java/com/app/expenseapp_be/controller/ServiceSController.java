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

import com.app.expenseapp_be.model.ServiceS;
import com.app.expenseapp_be.service.ServiceSService;

@RestController
@RequestMapping("/api/serviceS")
@CrossOrigin
public class ServiceSController {
    
    @Autowired
    ServiceSService serviceSService;

    @GetMapping("all")
    public ResponseEntity<List<ServiceS>> getAllServiceSStatistic() {
        return new ResponseEntity<>(serviceSService.getAllServiceS(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ServiceS> createServiceSStatistic(@RequestBody ServiceS newServiceS) {
        return new ResponseEntity<>(serviceSService.saveServiceS(newServiceS), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{description}/{amount}")
    public ResponseEntity<String> deleteServiceSByDescAndAmount(@PathVariable("description") String description,
            @PathVariable("amount") String amount) {
        serviceSService.deleteServiceSByDescAndAmo(description, amount);
        return new ResponseEntity<String>("delete successful", HttpStatus.OK);
    }
}
