package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Simon;

import java.util.List;

public interface SimonService {

    Simon creer(Simon simon);

    List<Simon> lire();

    Simon modifier(String IdCase, Simon simon);

    String supprimer(String IdCase);

}
