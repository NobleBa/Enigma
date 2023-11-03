package com.projetjee.enigma.models;

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
    @Column(length = 500, name = "charade")
    private String charade;
    @Column(length = 500, name = "solution")
    private String solution;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Charade charade = (Charade) obj;

        if (!IdCharade.equals(charade.IdCharade)) return false;
        if (!charade.equals(charade.charade)) return false;
        if (!solution.equals(charade.solution)) return false;

        return true;
    }

}
