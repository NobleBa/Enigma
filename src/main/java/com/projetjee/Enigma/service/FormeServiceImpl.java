package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Forme;
import com.projetjee.Enigma.repository.FormeDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormeServiceImpl implements FormeService{

    private final FormeDAO formeDAO;

    @Override
    public Forme creer(Forme forme) {
        return formeDAO.save(forme);
    }

    @Override
    public List<Forme> lire() {
        return formeDAO.findAll();
    }

    @Override
    public Forme modifier(String IdForme, Forme forme) {
        return formeDAO.findById(IdForme)
                .map(p-> {
                    p.setNbCarre(p.getNbCarre());
                    p.setNbCroix(p.getNbCroix());
                    p.setNbRond(p.getNbRond());
                    p.setNbEtoile(p.getNbEtoile());
                    p.setNbTriangle(p.getNbTriangle());
                    return formeDAO.save(p);
                }).orElseThrow(() -> new RuntimeException("Forme non trouvé"));
    }

    @Override
    public String supprimer(String IdForme) {
        formeDAO.deleteById(IdForme);
        return "Forme supprimé";
    }
}
