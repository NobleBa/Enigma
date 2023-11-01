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
    @Column(length = 10, name = "NbRond")
    private int NbRond;
    @Column(length = 10, name = "NbTriangle")
    private String NbTriangle;
    @Column(length = 10, name = "NbCroix")
    private int NbCroix;
    @Column(length = 10, name = "NbCarre")
    private String NbCarre;
    @Column(length = 10, name = "NbEtoile")
    private String NbEtoile;

}
