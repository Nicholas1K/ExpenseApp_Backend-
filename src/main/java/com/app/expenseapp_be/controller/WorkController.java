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

import com.app.expenseapp_be.model.Work;
import com.app.expenseapp_be.service.WorkService;

@RestController
@RequestMapping("/api/work")
@CrossOrigin
public class WorkController {
    
    @Autowired
    WorkService workService;

    @GetMapping("/all")
    public ResponseEntity<List<Work>> getAllWorkStatistic(){

        return new ResponseEntity<>(workService.getAllWork(),HttpStatus.OK);
    } 

    @GetMapping("/find/{id}")
    public ResponseEntity<Work> getWorkStatisticById(@PathVariable long id){
        return new ResponseEntity<>(workService.findWorkById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{description}")
    public ResponseEntity<String> deleteWorkByDesc(@PathVariable("description") String description){
        workService.deleteWorkByDesk(description);
        return new ResponseEntity<String>("delete successful",HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Work> createWorkStatistic(@RequestBody Work newWork){
        return new ResponseEntity<>(workService.saveWork(newWork),HttpStatus.CREATED);
    }
}
