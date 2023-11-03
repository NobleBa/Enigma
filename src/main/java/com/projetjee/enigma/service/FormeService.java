package com.projetjee.enigma.service;

import com.projetjee.enigma.models.Forme;

import java.util.List;

public interface FormeService {

    Forme creer(Forme forme);

    List<Forme> lire();

    Forme modifier(String IdForme, Forme forme);

    String supprimer(String IdForme);

}
