package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Geoguesser;
import com.projetjee.Enigma.repository.GeoguesserDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GeoguesserServiceImpl implements GeoguesserService{

    private final GeoguesserDAO geoguesserDAO;

    @Override
    public Geoguesser creer(Geoguesser geoguesser) {
        return geoguesserDAO.save(geoguesser);
    }

    @Override
    public List<Geoguesser> lire() {
        return geoguesserDAO.findAll();
    }

    @Override
    public Geoguesser modifier(String IdGeo, Geoguesser geoguesser) {
        return geoguesserDAO.findById(IdGeo)
                .map(p-> {
                    p.setGuess(p.getGuess());
                    return geoguesserDAO.save(p);
                }).orElseThrow(() -> new RuntimeException("Geoguesser non trouvé"));
    }

    @Override
    public String supprimer(String IdGeo) {
        geoguesserDAO.deleteById(IdGeo);
        return "Geoguesser supprimé";
    }
}
