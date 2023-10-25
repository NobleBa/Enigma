package com.projetjee.Enigma.models;

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
    @Column(length = 250, name = "Poeme")
    private String charade;

}
