package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculController {
    @GetMapping("/calcul")
    public String calcul() {
        return "views/calcul";
    }
}