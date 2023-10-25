package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Forme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormeDAO extends JpaRepository<Forme, String> {
}