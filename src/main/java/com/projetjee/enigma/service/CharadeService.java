package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Charade;

import java.util.List;

public interface CharadeService {

    Charade creer(Charade charade);

    List<Charade> lire();

    Charade modifier(String IdCharade, Charade charade);

    String supprimer(String IdCharade);

}
