package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Forme;

import java.util.List;

public interface FormeService {

    Forme creer(Forme forme);

    List<Forme> lire();

    Forme modifier(String IdForme, Forme forme);

    String supprimer(String IdForme);

}
