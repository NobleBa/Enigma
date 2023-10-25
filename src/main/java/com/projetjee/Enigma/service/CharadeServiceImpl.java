package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Charade;
import com.projetjee.Enigma.repository.CharadeDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CharadeServiceImpl implements CharadeService{

    private final CharadeDAO charadeDAO;

    @Override
    public Charade creer(Charade charade) {
        return charadeDAO.save(charade);
    }

    @Override
    public List<Charade> lire() {
        return charadeDAO.findAll();
    }

    @Override
    public Charade modifier(String IdCharade, Charade charade) {
        return charadeDAO.findById(IdCharade)
                .map(p-> {
                    p.setCharade(p.getCharade());
                    p.setSolution(p.getSolution());
                    return charadeDAO.save(p);
                }).orElseThrow(() -> new RuntimeException("Charade non trouvé"));
    }

    @Override
    public String supprimer(String IdCharade) {
        charadeDAO.deleteById(IdCharade);
        return "Charade supprimé";
    }
}
