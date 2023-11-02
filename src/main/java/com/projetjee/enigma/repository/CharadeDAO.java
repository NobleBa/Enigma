package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Charade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharadeDAO extends JpaRepository<Charade, String> {
}