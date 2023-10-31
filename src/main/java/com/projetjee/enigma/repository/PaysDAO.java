package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysDAO extends JpaRepository<Pays, String> {
}
