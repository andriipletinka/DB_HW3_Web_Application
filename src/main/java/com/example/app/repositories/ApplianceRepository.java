package com.example.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.app.entities.Appliance;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplianceRepository extends CrudRepository<Appliance, Integer> {
    @Query(value = "SELECT * FROM medical_appliance WHERE appType LIKE CONCAT('%', :keyword, '%')" +
            "OR ID LIKE CONCAT('%', :keyword, '%')" +
            "OR hospName LIKE CONCAT('%', :keyword, '%')" +
            "OR hospCity LIKE CONCAT('%', :keyword, '%');", nativeQuery = true)
    List<Appliance> findByKeyword(@Param("keyword") String keyword);
}