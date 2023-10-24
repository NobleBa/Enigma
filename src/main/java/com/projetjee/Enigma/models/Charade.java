package com.projetjee.Enigma.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "charade")
@Getter
@Setter
@NoArgsConstructor
public class Charade {
    @Id
    @Column(length = 50, name = "IdCharade")
    private String IdCharade;
    @Column(length = 250, name = "charade")
    private String charade;
    @Column(length = 250, name = "solution")
    private String solution;

}
