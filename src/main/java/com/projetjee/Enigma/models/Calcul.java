package com.projetjee.Enigma.models;

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
    @Column(length = 50, name = "IdBloc")
    private String IdBloc;
    @Column(length = 250, name = "Bloc")
    private String Bloc;
    @Column(length = 250, name = "solution")
    private String solution;

}
