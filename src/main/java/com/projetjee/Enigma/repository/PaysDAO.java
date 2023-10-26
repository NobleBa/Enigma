package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysDAO extends JpaRepository<Pays, String> {
}
