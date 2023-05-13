package com.example.app.services;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.entities.Patient;
import com.example.app.repositories.PatientRepository;
@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public List<Patient> getAllPatients(){
        List<Patient> list =  (List<Patient>)repository.findAll();
        return list;
    }

    public void addPatient(String hospName, String hospCity, Integer roomNo, String firstName
    , String lastName, String disease, Date dateOfPlacing) {
        repository.insertPatient(hospName, hospCity, roomNo, firstName, lastName, disease, dateOfPlacing);
    }

    public List<Patient> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}