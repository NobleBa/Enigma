package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.BlocCalcul;

import java.util.List;

public interface BlocCalculService {

    BlocCalcul creer(BlocCalcul bloc);

    List<BlocCalcul> lire();

    BlocCalcul modifier(String IdBloc, BlocCalcul bloc);

    String supprimer(String IdBloc);

}
