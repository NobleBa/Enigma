package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SymbolController {
    @GetMapping("/symbol")
    public String symbol() {
        return "views/symbol";
    }
}