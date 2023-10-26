package com.projetjee.Enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharadeController {
    @GetMapping("/charade")
    public String charade() {
        return "views/charade";
    }
}
