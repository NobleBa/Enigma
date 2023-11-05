package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Charade;
import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.UtilisateurDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.projetjee.enigma.repository.CharadeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
public class CharadeController {

    @Autowired
    private CharadeDAO charadeDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @GetMapping("/charade")
    public String charade(HttpServletRequest request,Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            Charade charade1 = getRandomCharadeFromDatabase();
            Charade charade2 = getRandomCharadeFromDatabase();
            Charade charade3 = getRandomCharadeFromDatabase();
            while (charade2.equals(charade1)){
                charade2 = getRandomCharadeFromDatabase();
            }
            while (charade3.equals(charade2) || charade3.equals(charade1)){
                charade3 = getRandomCharadeFromDatabase();
            }
            model.addAttribute("charade1", charade1);
            model.addAttribute("charade2", charade2);
            model.addAttribute("charade3", charade3);
            return "views/charade";
        }else {
            return "redirect:/login";
        }
    }
    @PostMapping("/checkSolution")
    @ResponseBody
    public String checkSolution(@RequestParam String inputSolution, @RequestParam String charadeId,@RequestParam String idUser) {
        String response = "ko";

        Charade charade = charadeDAO.findById(charadeId).orElse(null);

        if (charade != null && inputSolution.equalsIgnoreCase(charade.getSolution())) {
            response = "ok";
        }else{
            Utilisateur user = utilisateurDAO.getById(idUser);
            if (user.getVie() == 1){
                user.setVie(user.getVie()-1);
                user.setNiveau(0);
                utilisateurDAO.save(user);
                response = "/";
            }
        }
        return response;
    }

    private Charade getRandomCharadeFromDatabase() {
        List<Charade> allCharades = charadeDAO.findAll();

        int randomIndex = new Random().nextInt(allCharades.size());

        return allCharades.get(randomIndex);
    }
}