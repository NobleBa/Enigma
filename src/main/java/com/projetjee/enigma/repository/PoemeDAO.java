package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Poeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoemeDAO extends JpaRepository<Poeme, String> {
}