package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Etudiant;
import com.mouhcine.SchoolSpringApp.bo.Filiere;
import com.mouhcine.SchoolSpringApp.bo.Inscription;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import com.mouhcine.SchoolSpringApp.services.IEtudiantService;
import com.mouhcine.SchoolSpringApp.services.IFiliereService;
import com.mouhcine.SchoolSpringApp.services.IInscriptionService;
import com.mouhcine.SchoolSpringApp.services.INiveauService;
import com.mouhcine.SchoolSpringApp.web.models.NiveauModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class NiveauController {
    @Autowired
    INiveauService niveauService;

    @Autowired
    IInscriptionService inscriptionService;
    @Autowired
    IEtudiantService etudiantService;

    @Autowired
    IFiliereService filiereService;
    @GetMapping("niveaux")
    public String index(@ModelAttribute("message") String message, Model model){
        List<Niveau> niveaux = niveauService.getAll();
        List<Filiere> filieres=filiereService.getAll();
        model.addAttribute("msg",message);
        model.addAttribute("filieresList",filieres);
        model.addAttribute("niveauxList",niveaux);
        model.addAttribute("niveauModel",new NiveauModel());

        return "admin/niveau";
    }

    @GetMapping("etudiants")
    public String etudiants(Model model){
        List<Etudiant> etudiantList=etudiantService.getAll();
        List<Niveau> niveaux = niveauService.getAll();
        model.addAttribute("niveauxList",niveaux);
        model.addAttribute("etudiantsList",etudiantList);
        return "admin/etudiants";
    }
    @GetMapping("etudiants/{niveau_id}")
    public String niveau_etu(@PathVariable(name = "niveau_id",required = false) Long niveau_id,Model model){
        List<Niveau> niveaux = niveauService.getAll();
        model.addAttribute("niveauxList",niveaux);
        if(niveau_id!=null){
            Optional<Niveau> niveau=niveauService.getById(niveau_id);
            List<Inscription> inscriptionList=inscriptionService.getByNiveau(niveau.get());
            model.addAttribute("inscriptionList",inscriptionList);
            return "admin/niveau_etudiants";
        }
        return "admin/form";
    }

    @RequestMapping(value = "addNiveau",method = RequestMethod.POST)
    public String addniveau(@ModelAttribute("niveauModel") NiveauModel niveauModel, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            // rq.setAttribute("typePerson", +person.getTypePerson());
            return "admin/niveau";
        }
        Niveau f = new Niveau();
        BeanUtils.copyProperties(niveauModel, f);
        niveauService.add(f);
        model.addAttribute("mgs","Niveau ajouter en success");
        return "redirect:/admin/niveaux";
    }

    @PostMapping("deleteniveau")
    public String delete(HttpServletRequest rq, RedirectAttributes redirectAttributes){
        Long id=Long.valueOf(rq.getParameter("idNiveau"));
        niveauService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Niveau est supprimer avec success");
        return "redirect:/admin/niveaux";
    }

}
