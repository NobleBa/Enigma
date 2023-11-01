package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoemeController {
    @GetMapping("/poeme")
    public String poeme() {
        return "views/poeme";
    }
}