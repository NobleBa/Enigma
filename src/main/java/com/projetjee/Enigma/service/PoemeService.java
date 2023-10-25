package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Poeme;

import java.util.List;

public interface PoemeService {

    Poeme creer(Poeme poeme);

    List<Poeme> lire();

    Poeme modifier(String IdPoeme, Poeme poeme);

    String supprimer(String IdPoeme);

}
