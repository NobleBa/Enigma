package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Charade;
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

    @GetMapping("/charade")
    public String charade(Model model) {
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
    }

    @PostMapping("/checkSolution")
    @ResponseBody
    public boolean checkSolution(@RequestParam String inputSolution, @RequestParam String charadeId) {
        boolean response = false;
        System.out.println("Valeur de inputSolution reçue : " + inputSolution);
        System.out.println("Id charade : " + charadeId);

        Charade charade = charadeDAO.findById(charadeId).orElse(null);

        if (charade != null && inputSolution.equalsIgnoreCase(charade.getSolution())) {
            response = true;
        }

        return response;
    }

    private Charade getRandomCharadeFromDatabase() {
        List<Charade> allCharades = charadeDAO.findAll();

        int randomIndex = new Random().nextInt(allCharades.size());

        return allCharades.get(randomIndex);
    }
}