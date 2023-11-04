package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.UtilisateurDAO;
import com.projetjee.enigma.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        return "views/registration";
    }

    @PostMapping("/registrationSubmit")
    @ResponseBody
    public boolean registrationSubmit(@RequestParam String email, @RequestParam String nom, @RequestParam String prenom, @RequestParam String mdp) {
        boolean response = false;
        System.out.println("On vérifie...");
        if (!utilisateurDAO.existsById(email)) {
            System.out.println("L'email n'est pas connue, alors on créé le compte.");
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setEmail(email);
            utilisateur.setMdp(mdp);
            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setVie(null);
            utilisateur.setNiveau(null);
            utilisateurService.creer(utilisateur);
            response = true;
        } else {
            System.out.println("L'email existe déjà dans la BDD");
        }
        return response;
    }
}