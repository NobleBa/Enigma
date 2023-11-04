package com.projetjee.enigma.controller;


import com.projetjee.enigma.models.BlocCalcul;
import com.projetjee.enigma.models.Calcul;
import com.projetjee.enigma.repository.BlocCalculDAO;
import com.projetjee.enigma.repository.CalculDAO;
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
public class CalculController {

    @Autowired
    private CalculDAO calculDAO;

    @Autowired
    private BlocCalculDAO blocCalculDAO;

    @GetMapping("/calcul")
    public String calcul(Model model) {
        BlocCalcul bloc = getRandomBlocFromDatabase();
        List<Calcul> allCalcul = calculDAO.findAllByIdBloc(bloc);
        model.addAttribute("bloc", bloc);
        model.addAttribute("allCalcul", allCalcul);
        return "views/calcul";
    }

    @PostMapping("/checkSolutionCalcul")
    @ResponseBody
    public Map<String, String> checkSolutionCalcul(@RequestParam String inputSolution, @RequestParam String blocId) {
        Map<String, String> response = new HashMap<>();
        System.out.println("c bon");
        System.out.println("Valeur de inputSolution reçue : " + inputSolution);
        System.out.println("Id bloc : " + blocId);

        BlocCalcul blocCalcul = blocCalculDAO.findById(blocId).orElse(null);

        if (blocCalcul != null && inputSolution.equalsIgnoreCase(blocCalcul.getSolution())) {
            response.put("message", "Bonne réponse !");
        } else {
            response.put("message", "Mauvaise réponse. Essayez à nouveau.");
        }
        return response;
    }
    private BlocCalcul getRandomBlocFromDatabase() {
        List<BlocCalcul> allBloc = blocCalculDAO.findAll();

        int randomIndex = new Random().nextInt(allBloc.size());

        return allBloc.get(randomIndex);
    }
}