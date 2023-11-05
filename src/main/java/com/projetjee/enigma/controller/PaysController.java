package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Pays;
import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.PaysDAO;
import com.projetjee.enigma.repository.UtilisateurDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class PaysController {

    @Autowired
    private PaysDAO paysDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @GetMapping("/pays")
    public String pays(HttpServletRequest request,Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            if (utilisateur.getNiveau() >= 5) {
                Pays pays = getRandomPaysFromDatabase();
                model.addAttribute("pays", pays);
                return "views/pays";
            } else {
                return "redirect:/";
            }
        }else {
            return "redirect:/login";
        }
    }

    @PostMapping("/verifyContinent")
    @ResponseBody
    public boolean verifyContinent(@RequestParam String pays, @RequestParam String continent) {
        boolean response = paysDAO.existsByNompaysAndContinent(pays, continent);
        return response;
    }

    @PostMapping("/verifyFinE")
    @ResponseBody
    public boolean verifyFinE(@RequestParam String pays, @RequestParam boolean fine, @RequestParam String continent) {
        boolean response = paysDAO.existsByNompaysAndContinentAndFine(pays, continent, fine);
        return response;
    }

    @PostMapping("/verifyLittoral")
    @ResponseBody
    public boolean verifyLittoral(@RequestParam String pays, @RequestParam boolean fine, @RequestParam String continent, @RequestParam boolean littoral) {
        boolean response = paysDAO.existsByNompaysAndContinentAndFineAndLittoral(pays, continent, fine, littoral);
        return response;
    }

    @PostMapping("/verifyPopulation")
    @ResponseBody
    public boolean verifyPopulation(@RequestParam String pays, @RequestParam boolean fine, @RequestParam String continent, @RequestParam boolean littoral, @RequestParam boolean population) {
        boolean response = paysDAO.existsByNompaysAndContinentAndFineAndLittoralAndPopulationHuitMillions(pays, continent, fine, littoral, population);
        return response;
    }

    @PostMapping("/verifySurface")
    @ResponseBody
    public boolean verifySurface(@RequestParam String pays, @RequestParam boolean fine, @RequestParam String continent, @RequestParam boolean littoral, @RequestParam boolean population, @RequestParam boolean surface) {
        boolean response = paysDAO.existsByNompaysAndContinentAndFineAndLittoralAndPopulationHuitMillionsAndAndSurfaceMillion(pays, continent, fine, littoral, population, surface);
        return response;
    }

    @PostMapping("/verifyUnique")
    @ResponseBody
    public boolean verifyUnique(@RequestParam String pays, @RequestParam boolean fine, @RequestParam String continent, @RequestParam boolean littoral, @RequestParam boolean population, @RequestParam boolean surface, @RequestParam String unique) {
        boolean response = paysDAO.existsByNompaysAndContinentAndFineAndLittoralAndPopulationHuitMillionsAndAndSurfaceMillionAndQuestionUnique(pays, continent, fine, littoral, population, surface, unique);
        return response;
    }
    @PostMapping("/checkVie")
    @ResponseBody
    public boolean checkVie(@RequestParam String idUser){
        boolean response = false;
        Utilisateur user = utilisateurDAO.getById(idUser);
        if(user.getVie()!=0){
            response = true;
        }
        return response;
    }

    private Pays getRandomPaysFromDatabase() {
        List<Pays> allPays = paysDAO.findAll();

        int randomIndex = new Random().nextInt(allPays.size());

        return allPays.get(randomIndex);
    }

}