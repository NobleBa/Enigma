package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Calcul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculDAO extends JpaRepository<Calcul, String> {
}