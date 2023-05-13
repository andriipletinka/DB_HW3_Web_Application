package com.example.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.app.Appointment;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    @Query(value = "SELECT * FROM appointments WHERE patFirstName LIKE CONCAT('%', :keyword, '%')" +
            "OR patLastName LIKE CONCAT('%', :keyword, '%')" +
            "OR CONCAT(patFirstName, ' ', patLastName) LIKE CONCAT('%', :keyword, '%')" +
            "OR appointID LIKE CONCAT('%', :keyword, '%')" +
            "OR docFirstName LIKE CONCAT('%', :keyword, '%')" +
            "OR docLastName LIKE CONCAT('%', :keyword, '%')" +
            "OR CONCAT(docFirstName, ' ', docLastName) LIKE CONCAT('%', :keyword, '%');", nativeQuery = true)
    List<Appointment> findByKeyword(@Param("keyword") String keyword);
}
