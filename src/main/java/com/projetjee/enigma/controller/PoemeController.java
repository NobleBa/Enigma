package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Poeme;
import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.PoemeDAO;
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
public class PoemeController {

    @Autowired
    private PoemeDAO poemeDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @GetMapping("/poeme")
    public String poeme(HttpServletRequest request,Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            if (utilisateur.getNiveau() >= 4) {
                Poeme poeme = getRandomPoemeFromDatabase();
                model.addAttribute("poeme", poeme);
                return "views/poeme";
            } else {
                return "redirect:/";
            }
        }else {
            return "redirect:/login";
        }
    }

    @PostMapping("/checkSolutionPoeme")
    @ResponseBody
    public String checkSolutionPoeme(@RequestParam String inputSolution, @RequestParam String poemeId,@RequestParam String idUser) {
        String response = "ko";

        Poeme poeme = poemeDAO.findById(poemeId).orElse(null);

        if (poeme != null && inputSolution.equalsIgnoreCase(poeme.getSolution())) {
            response = "ok";
        }else {
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
    private Poeme getRandomPoemeFromDatabase(){
        List<Poeme> allPoeme = poemeDAO.findAll();
        int randomIndex = new Random().nextInt(allPoeme.size());
        return allPoeme.get(randomIndex);
    }
}