package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.BlocCalcul;
import com.projetjee.enigma.models.Calcul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculDAO extends JpaRepository<Calcul, String> {
    List<Calcul> findAllByIdBloc(BlocCalcul bloc);
}