package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Forme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormeDAO extends JpaRepository<Forme, String> {
}