package com.projetjee.enigma.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "calcul")
@Getter
@Setter
@NoArgsConstructor
public class Calcul {
    @Id
    @Column(length = 50, name = "IdCalcul")
    private String IdCalcul;
    @Column(length = 250, name = "NumBloc")
    private int NumBloc;
    @Column(length = 250, name = "Formule")
    private String Formule;

}
