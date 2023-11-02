package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaysController {
    @GetMapping("/pays")
    public String pays() {
        return "views/pays";
    }
}