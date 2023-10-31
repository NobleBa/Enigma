package com.projetjee.enigma.service;

import com.projetjee.enigma.models.Pays;

import java.util.List;

public interface PaysService {

    Pays creer(Pays pays);

    List<Pays> lire();

    Pays modifier(String Nompays, Pays pays);

    String supprimer(String Nompays);

}
