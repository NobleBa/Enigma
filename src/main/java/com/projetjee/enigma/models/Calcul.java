package com.projetjee.enigma.models;

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
    @ManyToOne
    @JoinColumn (name="IdBloc")
    private BlocCalcul idBloc;
    @Column(length = 10, name = "Place")
    private int Place;
    @Column(length = 250, name = "Formule")
    private String Formule;

}
