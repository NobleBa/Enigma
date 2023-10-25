package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Geoguesser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoguesserDAO extends JpaRepository<Geoguesser, String> {
}