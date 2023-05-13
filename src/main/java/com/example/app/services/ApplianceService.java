package com.example.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.entities.Appliance;
import com.example.app.repositories.ApplianceRepository;
@Service
public class ApplianceService {
    @Autowired
    private ApplianceRepository repository;

    public List<Appliance> getAllAppliance(){
        List<Appliance> list =  (List<Appliance>)repository.findAll();
        return list;
    }

    public List<Appliance> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}