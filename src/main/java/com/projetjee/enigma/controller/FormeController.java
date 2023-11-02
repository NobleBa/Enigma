package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormeController {
    @GetMapping("/forme")
    public String forme() {
        return "views/forme";
    }
}