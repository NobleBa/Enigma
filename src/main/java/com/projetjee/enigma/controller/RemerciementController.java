package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RemerciementController {
    @GetMapping("/remerciement")
    public String remerciement() {
        return "views/remerciement";
    }
}