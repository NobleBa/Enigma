package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Charade;
import org.springframework.ui.Model;
import com.projetjee.enigma.repository.CharadeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CharadeController {

    @Autowired
    private CharadeDAO charadeDAO;

    @GetMapping("/charade")
    public String charade(Model model) {
        Charade charade = charadeDAO.findById("1").orElse(null);
        model.addAttribute("charade", charade);
        return "views/charade";
    }

    @PostMapping("/verifyAnswer")
    public String verifyAnswer(@RequestParam String answer, Model model) {
        /*Charade charade = charadeDAO.findById("1").orElse(null);
        if (charade != null && charade.getSolution().equalsIgnoreCase(answer)) {
            model.addAttribute("result", "Bonne réponse !");
        } else {
            model.addAttribute("result", "Mauvaise réponse. Réessayez !");
        }*/
        return "views/charade";
    }
}
