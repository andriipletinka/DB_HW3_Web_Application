package com.example.app.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.app.entities.Patient;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Query(value = "SELECT * FROM patient WHERE firstName LIKE CONCAT('%', :keyword, '%')" +
            "OR lastName LIKE CONCAT('%', :keyword, '%')" +
            "OR CONCAT(firstName, ' ', lastName) LIKE CONCAT('%', :keyword, '%')" +
            "OR persID LIKE CONCAT('%', :keyword, '%');", nativeQuery = true)
    List<Patient> findByKeyword(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO patient (hospName, hospCity, roomNo, firstName, lastName, disease, dateOfPlacing)" +
            "VALUES (:hospName, :hospCity, :roomNo, :firstName, :lastName, :disease, :dateOfPlacing);",  nativeQuery = true)
    void insertPatient(@Param("hospName") String hospName,
                       @Param("hospCity") String hospCity,
                       @Param("roomNo") Integer roomNo,
                       @Param("firstName") String firstName,
                       @Param("lastName") String lastName,
                       @Param("disease") String disease,
                       @Param("dateOfPlacing") Date dateOfPlacing
                       );
}
