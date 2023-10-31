package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.Calcul;
import com.projetjee.Enigma.repository.CalculDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalculServiceImpl implements CalculService{

    private final CalculDAO calculDAO;

    @Override
    public Calcul creer(Calcul calcul) {
        return calculDAO.save(calcul);
    }

    @Override
    public List<Calcul> lire() {
        return calculDAO.findAll();
    }

    @Override
    public Calcul modifier(String IdCalcul, Calcul calcul) {
        return calculDAO.findById(IdCalcul)
                .map(p-> {
                    p.setNumBloc(p.getNumBloc());
                    p.setFormule(p.getFormule());
                    return calculDAO.save(p);
                }).orElseThrow(() -> new RuntimeException("Calcul non trouvé"));
    }

    @Override
    public String supprimer(String IdCalcul) {
        calculDAO.deleteById(IdCalcul);
        return "Calcul supprimé";
    }
}
