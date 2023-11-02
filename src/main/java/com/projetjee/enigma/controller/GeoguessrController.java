package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeoguessrController {
    @GetMapping("/geoguessr")
    public String geoguessr() {
        return "views/geoguessr";
    }
}