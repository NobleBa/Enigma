package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Poeme;
import com.projetjee.Enigma.repository.PoemeDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PoemeServiceImpl implements PoemeService{

    private final PoemeDAO poemeDAO;

    @Override
    public Poeme creer(Poeme poeme) {
        return poemeDAO.save(poeme);
    }

    @Override
    public List<Poeme> lire() {
        return poemeDAO.findAll();
    }

    @Override
    public Poeme modifier(String IdPoeme, Poeme poeme) {
        return poemeDAO.findById(IdPoeme)
                .map(p-> {
                    p.setPoeme(p.getPoeme());
                    return poemeDAO.save(p);
                }).orElseThrow(() -> new RuntimeException("Poeme non trouvé"));
    }

    @Override
    public String supprimer(String IdPoeme) {
        poemeDAO.deleteById(IdPoeme);
        return "Poeme supprimé";
    }
}
