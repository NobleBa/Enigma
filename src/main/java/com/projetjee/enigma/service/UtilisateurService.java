package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur creer(Utilisateur utilisateur);

    List<Utilisateur> lire();

    Utilisateur modifier(String email, Utilisateur utilisateur);

    String supprimer(String email);

}
