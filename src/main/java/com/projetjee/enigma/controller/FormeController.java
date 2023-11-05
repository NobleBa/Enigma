package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Forme;
import com.projetjee.enigma.repository.FormeDAO;
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
public class FormeController {
    @Autowired
    private FormeDAO formeDAO;
    @GetMapping("/forme")
    public String forme(Model model) {
        Forme forme = getRandomFormeFromDatabase();
        model.addAttribute("forme",forme);
        return "views/forme";
    }

    @PostMapping("/checkSolutionForme")
    @ResponseBody
    public boolean checkSolutionForme(@RequestParam String inputSolution, @RequestParam String formeId) {
        boolean response = false;

        Forme forme = formeDAO.findById(formeId).orElse(null);

        if (forme != null && inputSolution.equals(String.valueOf(forme.getNombre()))) {
            response = true;
        }
        return response;
    }
    private Forme getRandomFormeFromDatabase() {
        List<Forme> allForme = formeDAO.findAll();

        int randomIndex = new Random().nextInt(allForme.size());

        return allForme.get(randomIndex);
    }
}