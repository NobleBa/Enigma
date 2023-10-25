package com.projetjee.Enigma.service;

import com.projetjee.Enigma.models.BlocCalcul;
import com.projetjee.Enigma.repository.BlocCalculDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocCalculServiceImpl implements BlocCalculService{

    private final BlocCalculDAO blocCalculDAO;

    @Override
    public BlocCalcul creer(BlocCalcul blocCalcul) {
        return blocCalculDAO.save(blocCalcul);
    }

    @Override
    public List<BlocCalcul> lire() {
        return blocCalculDAO.findAll();
    }

    @Override
    public BlocCalcul modifier(String IdBloc, BlocCalcul blocCalcul) {
        return blocCalculDAO.findById(IdBloc)
                .map(p-> {
                    p.setNumBloc(p.getNumBloc());
                    p.setSolution(p.getSolution());
                    return blocCalculDAO.save(p);
                }).orElseThrow(() -> new RuntimeException("Bloc non trouvé"));
    }

    @Override
    public String supprimer(String IdBloc) {
        blocCalcul.deleteById(IdBloc);
        return "Bloc supprimé";
    }
}   
