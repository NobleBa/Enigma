package com.projetjee.enigma.controller;

import com.projetjee.enigma.models.Utilisateur;
import com.projetjee.enigma.repository.UtilisateurDAO;
import com.projetjee.enigma.service.UtilisateurService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccueilController {

    @Autowired
    UtilisateurDAO utilisateurDAO;
    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping("/")
    public String accueil(HttpServletRequest request, Model model) {
        boolean connecte = false;
        HttpSession session = request.getSession();
        String utilisateurConnecte = (String) session.getAttribute("email");
        if (utilisateurConnecte != null){
            Utilisateur utilisateur = utilisateurDAO.getReferenceById(utilisateurConnecte);
            connecte = true;
            if(utilisateur.getEmail().equals("admin@admin.fr")){
                utilisateur.setNiveau(10);
                utilisateur.setVie(5);
                utilisateurDAO.save(utilisateur);
            }
            model.addAttribute("utilisateur", utilisateur);
            model.addAttribute("connecte", connecte);
            return "views/index";
        } else {
            model.addAttribute("connecte", connecte);
            return "redirect:/login";
        }

    }

    @PostMapping("/vieDebut")
    @ResponseBody
    public void vieDebut(@RequestParam String idUser) {
        Utilisateur user = utilisateurDAO.getById(idUser);
        user.setVie(5);
        if (!user.getEmail().equals("admin@admin.fr")){
            user.setNiveau(1);
        }else{
            user.setNiveau(10);
        }
        utilisateurDAO.save(user);
    }
    @PostMapping("/perdreVie")
    @ResponseBody
    public String perdreVie(@RequestParam String idUser) {
        Utilisateur user = utilisateurDAO.getById(idUser);
        if (user.getVie() > 0) {
            user.setVie(user.getVie() - 1);
            utilisateurDAO.save(user);
            return "success";
        }
        return "error";
    }

    @GetMapping("/nombreDeVies")
    @ResponseBody
    public int getNombreDeVies(@RequestParam String idUser) {
        Utilisateur user = utilisateurDAO.getById(idUser);
        return user.getVie();
    }

    @PostMapping("/gainNiveau")
    @ResponseBody
    public void gainNiveau(@RequestParam String idUser) {
        Utilisateur user = utilisateurDAO.getById(idUser);
        if (user.getNiveau() < 9) {
            user.setNiveau(user.getNiveau()+1);
            utilisateurDAO.save(user);
        }
    }

    @PostMapping("/deleteCompte")
    @ResponseBody
    public String deleteCompte(@RequestParam String idUser) {
        Utilisateur user = utilisateurDAO.getById(idUser);
        utilisateurDAO.delete(user);
        System.out.println("supprimer");
        return "/logout";
    }
}
