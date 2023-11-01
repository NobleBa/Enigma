package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Simon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimonDAO extends JpaRepository<Simon, String> {
}