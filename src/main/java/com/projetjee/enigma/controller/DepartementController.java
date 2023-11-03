package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DepartementController {
    @GetMapping("/departement")
    public String departement() {
        return "views/departement";
    }

    @PostMapping("/checkSolutionDep")
    @ResponseBody
    public Map<String, String> checkSolution(@RequestParam String inputSolution) {
        Map<String, String> response = new HashMap<>();
        System.out.println("Valeur de inputSolution reçue : " + inputSolution);

        if (inputSolution == "ISERE") {
            response.put("message", "Bonne réponse !");
        } else {
            response.put("message", "Mauvaise réponse. Essayez à nouveau.");
        }

        return response;
    }
}