package com.projetjee.enigma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DepartementController {
    @GetMapping("/departement")
    public String departement() {
        return "views/departement";
    }

    @PostMapping("/checkSolutionDep")
    @ResponseBody
    public boolean checkSolutionDep(@RequestParam String inputSolution) {
        boolean response = false;
        if (inputSolution.equals("ISERE")) {
            response = true;
        }
        return response;
    }
}