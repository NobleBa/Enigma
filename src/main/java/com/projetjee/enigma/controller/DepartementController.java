package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartementController {
    @GetMapping("/departement")
    public String departement() {
        return "views/departement";
    }
}