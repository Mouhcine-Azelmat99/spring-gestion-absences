package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Coordination;
import com.mouhcine.SchoolSpringApp.bo.Enseignant;
import com.mouhcine.SchoolSpringApp.bo.Filiere;
import com.mouhcine.SchoolSpringApp.services.ICoordinationService;
import com.mouhcine.SchoolSpringApp.services.IEnseignantService;
import com.mouhcine.SchoolSpringApp.services.IFiliereService;
import com.mouhcine.SchoolSpringApp.web.models.FiliereModel;
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
@RequestMapping("/admin")
public class FiliereController {
    @Autowired
    IFiliereService filiereService;

    @Autowired
    IEnseignantService enseignantService;

    @Autowired
    ICoordinationService coordinationService;

    @GetMapping("filiere")
    public String index(@ModelAttribute("message") String message,Model model){
        List<Filiere> filieres = filiereService.getAll();
        model.addAttribute("msg",message);
        model.addAttribute("filiersList",filieres);
        return "admin/filiere";
    }
    @GetMapping("addfiliere")
    public String addPage(Model model){
        model.addAttribute("filiereModel",new FiliereModel());
        return "admin/addfiliere";
    }

    @RequestMapping(value = "addFiliere",method = RequestMethod.POST)
    public String addfiliere(@ModelAttribute("filiereModel") FiliereModel filiereModel, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            // rq.setAttribute("typePerson", +person.getTypePerson());
            return "admin/filiere";
        }
        Filiere f = new Filiere();
        BeanUtils.copyProperties(filiereModel, f);
        filiereService.add(f);
        model.addAttribute("mgs","Filiere ajouter en success");
        return "redirect:/admin/filiere";
    }

    @GetMapping("filiere/coordinateur")
    public String affecterPage(HttpServletRequest rq, RedirectAttributes redirectAttributes,Model model){
        Long id=Long.valueOf(rq.getParameter("filiereId"));
        Optional<Filiere> filiere=filiereService.getById(id);
        List<Enseignant> enseignants=enseignantService.getAll();
        model.addAttribute("filiereModel",filiere);
        model.addAttribute("enseignants",enseignants);
        return "admin/filierecoordinateur";
    }

    @PostMapping("filiere/affecter")
    public String affecter(HttpServletRequest rq){
        Long filiereId=Long.valueOf(rq.getParameter("filiereId"));
        Optional<Filiere> filiere=filiereService.getById(filiereId);
        Long enseignantId=Long.valueOf(rq.getParameter("enseignantId"));
        Optional<Enseignant> enseignant =enseignantService.getById(enseignantId);
        Coordination coordination = new Coordination();
        coordination.setFiliere(filiere.orElse(null));
        coordination.setCoordinateur(enseignant.orElse(null));
        String dateFin = rq.getParameter("dateFin");
        String dateDebut = rq.getParameter("dateDebut");
        coordination.setDateDebut(dateDebut);
        coordination.setDateFin(dateFin);
        coordinationService.add(coordination);
        filiere.get().getCoordinations().add(coordination);
        enseignant.get().getCoordinations().add(coordination);
        filiereService.update(filiere.get());
        enseignantService.update(enseignant.get());
        return "admin/filiere";
    }
}
