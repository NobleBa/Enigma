package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Simon;
import com.projetjee.enigma.repository.SimonDAO;
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
public class SimonController {

    @Autowired
    private SimonDAO simonDAO;
    @GetMapping("/simon")
    public String simon(Model model) {
        Simon simon = getRandomSimonFromDatabase();
        model.addAttribute("simon", simon);
        return "views/simon";
    }
    @PostMapping("/checkSolutionPatern")
    @ResponseBody
    public Map<String, String> checkSolution(@RequestParam String inputSolution, @RequestParam String paternId) {
        Map<String, String> response = new HashMap<>();
        System.out.println("Valeur de inputSolution reçue : " + inputSolution);
        System.out.println("Id patern : " + paternId);

        // Utilisez l'ID de la charade pour récupérer la charade depuis la base de données
        Simon simon = simonDAO.findById(paternId).orElse(null);

        if (simon != null && inputSolution.equalsIgnoreCase(simon.getSolution())) {
            response.put("message", "Bonne réponse !");
        } else {
            response.put("message", "Mauvaise réponse. Essayez à nouveau.");
        }

        return response;
    }
    private Simon getRandomSimonFromDatabase() {
        List<Simon> allSimon = simonDAO.findAll();

        int randomIndex = new Random().nextInt(allSimon.size());

        return allSimon.get(randomIndex);
    }
}
