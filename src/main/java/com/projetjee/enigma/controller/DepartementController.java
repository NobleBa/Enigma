package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.UtilisateurDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
public class DepartementController {
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @GetMapping("/departement")
    public String departement(HttpServletRequest request, Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            return "views/departement";
        }else {
            return "redirect:/login";
        }
    }
        @PostMapping("/checkSolutionDep")
        @ResponseBody
        public String checkSolutionDep (@RequestParam String inputSolution, @RequestParam String idUser){
            String response = "ko";
            if (inputSolution.equals("ISERE")) {
                response = "ok";
            }else{
                Utilisateur user = utilisateurDAO.getById(idUser);
                if (user.getVie() == 1) {
                    user.setVie(user.getVie() - 1);
                    user.setNiveau(0);
                    utilisateurDAO.save(user);
                    response = "/";
                }
            }
            return response;
        }
}