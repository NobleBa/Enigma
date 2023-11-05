package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Forme;
import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.FormeDAO;
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
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class FormeController {
    @Autowired
    private FormeDAO formeDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @GetMapping("/forme")
    public String forme(HttpServletRequest request,Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            Forme forme = getRandomFormeFromDatabase();
            model.addAttribute("forme", forme);
            return "views/forme";
        }else {
            return "redirect:/login";
        }
    }

    @PostMapping("/checkSolutionForme")
    @ResponseBody
    public String checkSolutionForme(@RequestParam String inputSolution, @RequestParam String formeId,@RequestParam String idUser) {
        String response = "ko";

        Forme forme = formeDAO.findById(formeId).orElse(null);

        if (forme != null && inputSolution.equals(String.valueOf(forme.getNombre()))) {
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
    private Forme getRandomFormeFromDatabase() {
        List<Forme> allForme = formeDAO.findAll();

        int randomIndex = new Random().nextInt(allForme.size());

        return allForme.get(randomIndex);
    }
}