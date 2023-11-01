package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.BlocCalcul;
import com.projetjee.enigma.models.Calcul;
import com.projetjee.enigma.repository.BlocCalculDAO;
import com.projetjee.enigma.repository.CalculDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculController {
    @Autowired
    private CalculDAO calculDAO;

    @Autowired
    private BlocCalculDAO blocCalculDAO;

    @GetMapping("/calcul")
    public String calcul(Model model) {
        String idBloc = blocCalculDAO.getReferenceById("1").getIdBloc();
        String idCalcr = "1";
        Calcul calcul = calculDAO.findById(idCalcr).orElse(null);
        model.addAttribute("calcul", calcul);
        return "views/charade";
    }
}
