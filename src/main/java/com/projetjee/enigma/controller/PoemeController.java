package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Poeme;
import com.projetjee.enigma.repository.PoemeDAO;
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
    @GetMapping("/poeme")
    public String poeme(Model model) {
        Poeme poeme = getRandomPoemeFromDatabase();
        model.addAttribute("poeme",poeme);
        return "views/poeme";
    }

    @PostMapping("/checkSolutionPoeme")
    @ResponseBody
    public Map<String, String> checkSolutionPoeme(@RequestParam String inputSolution, @RequestParam String poemeId) {
        Map<String, String> response = new HashMap<>();
        System.out.println("Valeur de inputSolution reçue : " + inputSolution);
        System.out.println("Id poeme : " + poemeId);

        Poeme poeme = poemeDAO.findById(poemeId).orElse(null);

        if (poeme != null && inputSolution.equalsIgnoreCase(poeme.getSolution())) {
            response.put("message", "Bonne réponse !");
        } else {
            response.put("message", "Mauvaise réponse. Essayez à nouveau.");
        }

        return response;
    }
    private Poeme getRandomPoemeFromDatabase(){
        List<Poeme> allPoeme = poemeDAO.findAll();
        int randomIndex = new Random().nextInt(allPoeme.size());
        return allPoeme.get(randomIndex);
    }
}