package com.projetjee.enigma.controller;


import com.projetjee.enigma.models.BlocCalcul;
import com.projetjee.enigma.models.Calcul;
import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.BlocCalculDAO;
import com.projetjee.enigma.repository.CalculDAO;
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

import java.util.*;


@Controller
public class CalculController {

    @Autowired
    private CalculDAO calculDAO;

    @Autowired
    private BlocCalculDAO blocCalculDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @GetMapping("/calcul")
    public String calcul(HttpServletRequest request, Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null) {
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            if (utilisateur.getNiveau() >= 2) {
                BlocCalcul bloc = getRandomBlocFromDatabase();
                List<Calcul> allCalcul = calculDAO.findAllByIdBloc(bloc);
                Collections.sort(allCalcul, Comparator.comparingInt(Calcul::getPlace));
                model.addAttribute("bloc", bloc);
                model.addAttribute("allCalcul", allCalcul);
                return "views/calcul";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/checkSolutionCalcul")
    @ResponseBody
    public String checkSolutionCalcul(@RequestParam String inputSolution, @RequestParam String blocId, @RequestParam String idUser) {
        String response = "ko";

        BlocCalcul blocCalcul = blocCalculDAO.findById(blocId).orElse(null);

        if (blocCalcul != null && inputSolution.equalsIgnoreCase(blocCalcul.getSolution())) {
            response = "ok";
        } else {
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

    private BlocCalcul getRandomBlocFromDatabase() {
        List<BlocCalcul> allBloc = blocCalculDAO.findAll();

        int randomIndex = new Random().nextInt(allBloc.size());

        return allBloc.get(randomIndex);
    }
}