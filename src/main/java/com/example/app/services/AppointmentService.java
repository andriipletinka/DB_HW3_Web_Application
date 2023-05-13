package com.example.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.entities.Appointment;
import com.example.app.repositories.AppointmentRepository;
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> getAllAppointments(){
        List<Appointment> list =  (List<Appointment>)repository.findAll();
        return list;
    }

    public List<Appointment> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}