package com.projetjee.enigma.service;

import com.projetjee.enigma.models.BlocCalcul;

import java.util.List;

public interface BlocCalculService {

    BlocCalcul creer(BlocCalcul bloc);

    List<BlocCalcul> lire();

    BlocCalcul modifier(String IdBloc, BlocCalcul bloc);

    String supprimer(String IdBloc);

}
