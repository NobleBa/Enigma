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
    @Column(length = 50, name = "nompays")
    private String nompays;
    @Column(name = "continent")
    private String continent;
    @Column(name = "fine")
    private boolean fine;
    @Column(name = "littoral")
    private boolean littoral;
    @Column(name = "surfaceMillion")
    private boolean surfaceMillion;
    @Column(name = "populationHuitMillions")
    private boolean populationHuitMillions;
    @Column(name = "questionUnique")
    private String questionUnique;
    @OneToOne
    @JoinColumn(name = "IdGeo")
    private Geoguesser IdGeo;
}