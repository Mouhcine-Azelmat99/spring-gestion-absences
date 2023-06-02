package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Etudiant;
import com.mouhcine.SchoolSpringApp.bo.Inscription;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import com.mouhcine.SchoolSpringApp.services.IInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class EtudiantController {

    @Autowired
    private IInscriptionService inscriptionService;
    @GetMapping("inscriptions")
    public String inscriptions(Model model){
        List<Inscription> inscriptionsList=inscriptionService.getAll();
        model.addAttribute("inscriptionsList",inscriptionsList);
        return "admin/inscriptions";
    }

}
