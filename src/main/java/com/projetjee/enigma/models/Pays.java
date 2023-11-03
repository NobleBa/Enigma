package com.projetjee.enigma.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "pays")
@Getter
@Setter
@NoArgsConstructor
public class Pays {
    @Id
    @Column(length = 50, name = "IdPays")
    private String IdPays;
    @Column(length = 50, name = "Nompays")
    private String Nompays;
    @ManyToOne
    @JoinColumn(name = "IdGeo")
    private Geoguesser IdGeo;
    @Column(length = 10, name = "Q1")
    private boolean Q1;
    @Column(length = 10, name = "Q2")
    private boolean Q2;
    @Column(length = 10, name = "Q3")
    private boolean Q3;
    @Column(length = 10, name = "Q4")
    private boolean Q4;
    @Column(length = 10, name = "Q5")
    private boolean Q5;
    @Column(length = 10, name = "Q6")
    private boolean Q6;
}