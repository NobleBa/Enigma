package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.UtilisateurDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @Autowired
    UtilisateurDAO utilisateurDAO;

    @GetMapping("/")
    public String accueil(HttpServletRequest request, Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null){
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            return "views/index";
        } else {
            model.addAttribute("connecte", connecte);
            return "redirect:/login";
        }

    }
}
