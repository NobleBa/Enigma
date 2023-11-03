package com.projetjee.enigma.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "forme")
@Getter
@Setter
@NoArgsConstructor
public class Forme {
    @Id
    @Column(length = 50, name = "IdForme")
    private String IdForme;
    @Column(length = 250, name = "Nom")
    private int Nom;
    @Column(length = 10, name = "NbOrange")
    private String NbTriangle;
    @Column(length = 10, name = "NbBleu")
    private int NbCroix;
    @Column(length = 10, name = "NbGris")
    private String NbCarre;

}
