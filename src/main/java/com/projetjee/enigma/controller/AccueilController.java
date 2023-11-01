package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("/")
    public String accueil() {
        return "views/index";
    }
}
