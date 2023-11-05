package com.projetjee.enigma.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "simon")
@Getter
@Setter
@NoArgsConstructor
public class Simon {
    @Id
    @Column(length = 50, name = "Idpatern")
    private String Idpatern;
    @Column(length = 50, name = "Solution")
    private String Solution;
    @Column(length = 250, name = "Patern")
    private String Patern;

}
