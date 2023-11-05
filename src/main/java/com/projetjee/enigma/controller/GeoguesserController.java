package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Charade;
import com.projetjee.enigma.models.Pays;
import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.PaysDAO;
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
public class GeoguesserController {

    @Autowired
    private PaysDAO paysDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @GetMapping("/geoguesser")
    public String geoguesser(HttpServletRequest request,Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            Pays pays1 = getRandomPaysFromDatabase();
            Pays pays2 = getRandomPaysFromDatabase();
            Pays pays3 = getRandomPaysFromDatabase();
            while (pays2.equals(pays1)) {
                pays2 = getRandomPaysFromDatabase();
            }
            while (pays3.equals(pays2) || pays3.equals(pays1)) {
                pays3 = getRandomPaysFromDatabase();
            }
            model.addAttribute("pays1", pays1);
            model.addAttribute("pays2", pays2);
            model.addAttribute("pays3", pays3);
            return "views/geoguesser";
        }else {
            return "redirect:/login";
        }
    }

    @PostMapping("/checkPays")
    @ResponseBody
    public String checkPays(@RequestParam String inputSolution, @RequestParam String paysId,@RequestParam String idUser) {
        String response = "ko";

        Pays pays = paysDAO.findById(paysId).orElse(null);

        if (pays != null && inputSolution.equalsIgnoreCase(pays.getNompays())) {
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

    private Pays getRandomPaysFromDatabase() {
        List<Pays> allPays = paysDAO.findAll();

        int randomIndex = new Random().nextInt(allPays.size());

        return allPays.get(randomIndex);
    }
}