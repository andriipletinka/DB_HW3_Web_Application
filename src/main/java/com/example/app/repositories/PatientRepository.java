package com.example.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.app.entities.Patient;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Query(value = "SELECT * FROM patient WHERE firstName LIKE CONCAT('%', :keyword, '%')" +
            "OR lastName LIKE CONCAT('%', :keyword, '%')" +
            "OR CONCAT(firstName, ' ', lastName) LIKE CONCAT('%', :keyword, '%')" +
            "OR persID LIKE CONCAT('%', :keyword, '%');", nativeQuery = true)
    List<Patient> findByKeyword(@Param("keyword") String keyword);
}
