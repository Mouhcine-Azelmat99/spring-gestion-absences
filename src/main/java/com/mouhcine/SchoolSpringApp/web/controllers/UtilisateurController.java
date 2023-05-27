package com.mouhcine.SchoolSpringApp.web.controllers;


import com.mouhcine.SchoolSpringApp.bo.Compte;
import com.mouhcine.SchoolSpringApp.bo.Utilisateur;
import com.mouhcine.SchoolSpringApp.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {

    @Autowired
    IUtilisateurService utilisateurService;
    @GetMapping("/user")
    public String user(){
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setCin("AS3333");
        utilisateur.setNom("azelmat");
        utilisateur.setEmail("mouhcine@gmail.com");
        utilisateur.setNomArabe("ازلماط");
        utilisateur.setPrenom("Mouhcine");
        utilisateur.setPrenomArabe("محسن");
        utilisateur.setPhoto("img.jpg");

        utilisateurService.addUtilisateur(utilisateur);
        return "home";
    }
}
