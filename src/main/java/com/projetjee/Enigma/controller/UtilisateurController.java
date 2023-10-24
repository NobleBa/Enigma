package com.projetjee.Enigma.controller;

import com.projetjee.Enigma.models.Utilisateur;
import com.projetjee.Enigma.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return utilisateurService.creer(utilisateur);
    }

    @GetMapping("/read")
    public List<Utilisateur> read() {
        return utilisateurService.lire();
    }

    @PutMapping("/update/{email}")
    public Utilisateur update(@PathVariable String email,@RequestBody Utilisateur utilisateur) {
        return utilisateurService.modifier(email, utilisateur);
    }

    @DeleteMapping("/delete/{email}")
    public String delete(@PathVariable String email) {
        return utilisateurService.supprimer(email);
    }
}
