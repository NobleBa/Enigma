package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, String> {
    boolean existsByEmailAndMdp(String email, String mdp);
}
