package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Charade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharadeDAO extends JpaRepository<Charade, String> {
}