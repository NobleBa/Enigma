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
    @Column(length = 50, name = "Nom")
    private String Nom;
    @Column(length = 50, name = "Couleur")
    private String Couleur;
    @Column(length = 250, name = "Image")
    private String Image;
    @Column(length = 10, name = "Nombre")
    private int Nombre;

}
