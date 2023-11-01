package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Geoguesser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoguesserDAO extends JpaRepository<Geoguesser, String> {
}