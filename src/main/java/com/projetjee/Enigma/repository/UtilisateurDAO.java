package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, String> {
}
