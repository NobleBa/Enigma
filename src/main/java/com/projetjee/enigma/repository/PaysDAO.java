package com.projetjee.enigma.repository;

import com.projetjee.enigma.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysDAO extends JpaRepository<Pays, String> {
    boolean existsByNompaysAndContinent(String nompays, String continent);
    boolean existsByNompaysAndContinentAndFine(String nompays, String continent, boolean fine);
    boolean existsByNompaysAndContinentAndFineAndLittoral(String nompays, String continent, boolean fine, boolean littoral);
    boolean existsByNompaysAndContinentAndFineAndLittoralAndPopulationHuitMillions(String nompays, String continent, boolean fine, boolean littoral, boolean population);
    boolean existsByNompaysAndContinentAndFineAndLittoralAndPopulationHuitMillionsAndSurfaceMillion(String nompays, String continent, boolean fine, boolean littoral, boolean population, boolean surface);
    boolean existsByNompaysAndContinentAndFineAndLittoralAndPopulationHuitMillionsAndSurfaceMillionAndQuestionUnique(String nompays, String continent, boolean fine, boolean littoral, boolean population, boolean surface, String unique);
}
