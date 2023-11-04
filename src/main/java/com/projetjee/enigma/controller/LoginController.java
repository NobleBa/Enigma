package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.UtilisateurDAO;
import com.projetjee.enigma.service.UtilisateurService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @GetMapping("/login")
    public String registrationForm(Model model) {
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        return "views/login";
    }

    @PostMapping("/loginSubmit")
    @ResponseBody
    public String loginSubmit(@RequestParam String email, @RequestParam String mdp, HttpServletRequest request) {

        System.out.println("On vérifie...");
        if (utilisateurDAO.existsByEmailAndMdp(email, mdp)) {
            HttpSession session = request.getSession();
            System.out.println("C'est bon");
            session.setAttribute("email", email);
            return "success";
        } else {
            System.out.println("L'email ou le mot de passe est incorrect");
            return "failure";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }
}
