package com.projetjee.enigma.service;

import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.UtilisateurDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

    private final UtilisateurDAO utilisateurDAO;

    @Override
    public Utilisateur creer(Utilisateur utilisateur) {
        return utilisateurDAO.save(utilisateur);
    }

    @Override
    public List<Utilisateur> lire() {
        return utilisateurDAO.findAll();
    }

    @Override
    public Utilisateur modifier(String email, Utilisateur utilisateur) {
        return utilisateurDAO.findById(email)
                .map(p-> {
                    p.setVie(p.getVie());
                    p.setNiveau(p.getNiveau());
                    p.setNom(p.getNom());
                    p.setPrenom(p.getPrenom());
                    p.setMdp(p.getMdp());
                    return utilisateurDAO.save(p);
                }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    @Override
    public String supprimer(String email) {
        utilisateurDAO.deleteById(email);
        return "Utilisateur supprimé";
    }
}
