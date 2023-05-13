package com.example.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "persID", nullable = false)
    private Integer persID;

    @Column(name = "hospName", nullable = false)
    private String hospName;

    @Column(name = "hospCity", nullable = false)
    private String hospCity;

    @Column(name = "roomNo", nullable = false)
    private Integer roomNo;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "disease", nullable = false)
    private String disease;

    @Column(name = "dateOfPlacing", nullable = false)
    private Date dateOfPlacing;
}
