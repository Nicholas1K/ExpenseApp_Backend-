package com.app.expenseapp_be.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.expenseapp_be.model.Work;
import com.app.expenseapp_be.repository.WorkRepository;

@Service
public class WorkService {
    
    @Autowired
    WorkRepository workRepository;

    public Work saveWork(Work work){
        return workRepository.save(work);
    }

    public List<Work> getAllWork(){
        return workRepository.findAll();
    }

    public Work findWorkById(Long id){
        Optional<Work> tempW = workRepository.findById(id);

        if(tempW.isPresent()){
            return tempW.get();
        }else{
            return null;
        }
    }

    public void deleteWorkById(Long id){
        workRepository.deleteById(id);
    }
    public void deleteWorkByDesk(String desc){
       Work temp = workRepository.findByDescription(desc);
        workRepository.delete(temp);
       
    }
}
