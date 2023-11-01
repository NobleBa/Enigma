package com.projetjee.enigma.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "blocCalcul")
@Getter
@Setter
@NoArgsConstructor
public class BlocCalcul {
    @Id
    @Column(length = 50, name = "IdBloc")
    private String IdBloc;
    @Column(length = 250, name = "NumBloc")
    private int NumBloc;
    @Column(length = 250, name = "Solution")
    private String Solution;

}