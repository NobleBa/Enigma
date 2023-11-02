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
    @Column(length = 50, name = "Nompays")
    private String Nompays;
    @ManyToOne
    @JoinColumn(name = "IdPoeme")
    private Poeme IdPoeme;
    @OneToOne
    @JoinColumn(name = "IdGeo")
    private Geoguesser IdGeo;
    @Column(length = 10, name = "NumVers")
    private int NumVers;
}