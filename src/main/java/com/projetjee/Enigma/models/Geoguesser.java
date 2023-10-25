package com.projetjee.Enigma.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "geoguesser")
@Getter
@Setter
@NoArgsConstructor
public class Geoguesser {
    @Id
    @Column(length = 50, name = "IdGeo")
    private String IdGeo;
    @Column(length = 250, name = "guess")
    private String guess;

}