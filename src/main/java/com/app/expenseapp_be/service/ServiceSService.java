package com.app.expenseapp_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.expenseapp_be.model.ServiceS;
import com.app.expenseapp_be.repository.ServiceSRepository;
import java.util.List;

@Service
public class ServiceSService {
    
    @Autowired
    ServiceSRepository serviceSRepository;

    public ServiceS saveServiceS(ServiceS serviceS) {
        return serviceSRepository.save(serviceS);
    }

    public List<ServiceS> getAllServiceS() {
        return serviceSRepository.findAll();
    }

    public void deleteServiceSByDescAndAmo(String desc, String amou) {
        ServiceS temp = serviceSRepository.findByDescriptionAndAmount(desc, amou);
        serviceSRepository.delete(temp);
    }
}
