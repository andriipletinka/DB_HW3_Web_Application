package com.example.app;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.Patient;
import com.example.app.PatientRepository;
@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public List<Patient> getAllPatients(){
        List<Patient> list =  (List<Patient>)repository.findAll();
        return list;
    }

    public List<Patient> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}