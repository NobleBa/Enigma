package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Charade;
import com.projetjee.enigma.models.Pays;
import com.projetjee.enigma.repository.PaysDAO;
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
    @GetMapping("/geoguesser")
    public String geoguesser(Model model) {
        Pays pays1 = getRandomPaysFromDatabase();
        Pays pays2 = getRandomPaysFromDatabase();
        Pays pays3 = getRandomPaysFromDatabase();
        while (pays2.equals(pays1)) {
            pays2 = getRandomPaysFromDatabase();
        }
        while (pays3.equals(pays2) || pays3.equals(pays1)){
            pays3 = getRandomPaysFromDatabase();
        }
        model.addAttribute("pays1", pays1);
        model.addAttribute("pays2", pays2);
        model.addAttribute("pays3", pays3);
        return "views/geoguesser";
    }

    @PostMapping("/checkPays")
    @ResponseBody
    public boolean checkPays(@RequestParam String inputSolution, @RequestParam String paysId) {
        boolean response = false;

        Pays pays = paysDAO.findById(paysId).orElse(null);

        if (pays != null && inputSolution.equalsIgnoreCase(pays.getNompays())) {
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