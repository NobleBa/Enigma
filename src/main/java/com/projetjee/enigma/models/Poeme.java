package com.projetjee.enigma.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "poeme")
@Getter
@Setter
@NoArgsConstructor
public class Poeme {
    @Id
    @Column(length = 50, name = "IdPoeme")
    private String IdPoeme;
    @Column(length = 1000, name = "Poeme")
    private String poeme;
    @Column(length = 500, name = "Solution")
    private String Solution;
}
