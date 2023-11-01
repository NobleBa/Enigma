package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimonController {
    @GetMapping("/simon")
    public String simon() {
        return "views/simon";
    }
}