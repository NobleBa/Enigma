package com.projetjee.enigma.service;

import com.projetjee.enigma.models.Calcul;

import java.util.List;

public interface CalculService {

    Calcul creer(Calcul calcul);

    List<Calcul> lire();

    Calcul modifier(String IdCalcul, Calcul calcul);

    String supprimer(String IdCalcul);

}
