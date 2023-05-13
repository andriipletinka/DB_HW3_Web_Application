package com.example.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "medical_appliance")
public class Appliance {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer ID;

    @Column(name = "hospName", nullable = false)
    private String hospName;

    @Column(name = "hospCity", nullable = false)
    private String hospCity;

    @Column(name = "appType", nullable = false)
    private String appType;
}
