package com.projetjee.enigma.service;

import com.projetjee.enigma.models.Simon;

import java.util.List;

public interface SimonService {

    Simon creer(Simon simon);

    List<Simon> lire();

    Simon modifier(String IdCase, Simon simon);

    String supprimer(String IdCase);

}
