package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Calcul;

import java.util.List;

public interface CalculService {

    Calcul creer(Calcul calcul);

    List<Calcul> lire();

    Calcul modifier(String IdCalcul, Calcul calcul);

    String supprimer(String IdCalcul);

}
