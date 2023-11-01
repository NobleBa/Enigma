package com.projetjee.Enigma.repository;

import com.projetjee.Enigma.models.Simon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimonDAO extends JpaRepository<Simon, String> {
}