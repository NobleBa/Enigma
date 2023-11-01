package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Calcul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculDAO extends JpaRepository<Calcul, String> {
}