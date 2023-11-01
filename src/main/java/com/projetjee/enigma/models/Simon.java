package com.projetjee.enigma.models;

import lombok.AllArgsConstructor;
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
    @Column(length = 50, name = "IdCase")
    private String IdCase;
    @Column(length = 250, name = "Active")
    private boolean Active;

}
