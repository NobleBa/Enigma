package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Poeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoemeDAO extends JpaRepository<Poeme, String> {
}