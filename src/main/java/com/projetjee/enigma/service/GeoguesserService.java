package com.projetjee.enigma.service;

import com.projetjee.enigma.models.Geoguesser;

import java.util.List;

public interface GeoguesserService {

    Geoguesser creer(Geoguesser geoguesser);

    List<Geoguesser> lire();

    Geoguesser modifier(String IdGeo, Geoguesser geoguesser);

    String supprimer(String IdGeo);

}
