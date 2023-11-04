package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Pays;
import com.projetjee.enigma.repository.PaysDAO;
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

    @GetMapping("/pays")
    public String pays(Model model) {
        Pays pays = getRandomPaysFromDatabase();
        model.addAttribute("pays", pays);
        return "views/pays";
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

    private Pays getRandomPaysFromDatabase() {
        List<Pays> allPays = paysDAO.findAll();

        int randomIndex = new Random().nextInt(allPays.size());

        return allPays.get(randomIndex);
    }
}