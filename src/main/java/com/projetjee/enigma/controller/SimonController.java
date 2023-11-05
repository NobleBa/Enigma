package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Simon;
import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.SimonDAO;
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

import java.util.List;
import java.util.Random;

@Controller
public class SimonController {

    @Autowired
    private SimonDAO simonDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @GetMapping("/simon")
    public String simon(HttpServletRequest request,Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            if (utilisateur.getNiveau() >= 6){
                Simon simon = getRandomSimonFromDatabase();
                model.addAttribute("simon", simon);
                return "views/simon";
            } else {
                return "redirect:/";
            }
        }else {
            return "redirect:/login";
        }
    }
    @PostMapping("/checkSolutionPatern")
    @ResponseBody
    public String checkSolution(@RequestParam String inputSolution, @RequestParam String paternId,@RequestParam String idUser) {
        String response = "ko";

        Simon simon = simonDAO.findById(paternId).orElse(null);

        if (simon != null && inputSolution.equalsIgnoreCase(simon.getSolution())) {
            response="ok";
        }else {
            Utilisateur user = utilisateurDAO.getById(idUser);
            if (user.getVie() == 1) {
                user.setVie(0);
                user.setNiveau(0);
                utilisateurDAO.save(user);
                response = "/";
            }
        }
        return response;
    }

    private Simon getRandomSimonFromDatabase() {
        List<Simon> allSimon = simonDAO.findAll();

        int randomIndex = new Random().nextInt(allSimon.size());

        return allSimon.get(randomIndex);
    }
}
