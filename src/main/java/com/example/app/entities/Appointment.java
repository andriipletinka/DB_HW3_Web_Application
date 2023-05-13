package com.example.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "appointID", nullable = false)
    private Integer appointID;

    @Column(name = "hospName", nullable = false)
    private String hospName;

    @Column(name = "hospCity", nullable = false)
    private String hospCity;

    @Column(name = "appDate", nullable = false)
    private Date appDate;

    @Column(name = "patFirstName", nullable = false)
    private String patFirstName;

    @Column(name = "patLastName", nullable = false)
    private String patLastName;

    @Column(name = "docFirstName", nullable = false)
    private String docFirstName;

    @Column(name = "docLastName", nullable = false)
    private String docLastName;
}
