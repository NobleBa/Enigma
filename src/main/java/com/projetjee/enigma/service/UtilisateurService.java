package com.projetjee.enigma.service;

import com.projetjee.enigma.models.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur creer(Utilisateur utilisateur);

    List<Utilisateur> lire();

    Utilisateur modifier(String email, Utilisateur utilisateur);

    String supprimer(String email);

}
