package com.projetjee.enigma.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@NoArgsConstructor
public class Utilisateur {
    @Id
    @Column(length = 50, name = "email")
    private String email;
    @Column(length = 250, name = "nom")
    private String nom;
    @Column(length = 250, name = "prenom")
    private String prenom;
    @Column(length = 250, name = "mdp")
    private String mdp;
    @Column(name = "niveau")
    private Integer niveau;
    @Column(name = "vie")
    private Integer vie;

}
