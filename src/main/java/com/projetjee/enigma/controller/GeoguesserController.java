package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeoguesserController {
    @GetMapping("/geoguesser")
    public String geoguesser() {
        return "views/geoguesser";
    }
}