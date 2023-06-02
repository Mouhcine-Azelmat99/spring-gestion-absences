package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Filiere;
import com.mouhcine.SchoolSpringApp.bo.Module;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import com.mouhcine.SchoolSpringApp.services.IFiliereService;
import com.mouhcine.SchoolSpringApp.services.IModuleService;
import com.mouhcine.SchoolSpringApp.services.INiveauService;
import com.mouhcine.SchoolSpringApp.web.models.ModuleModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class ModuleController {
    @Autowired
    INiveauService niveauService;

    @Autowired
    IModuleService moduleService;
    @GetMapping("modules")
    public String index(@ModelAttribute("message") String message, Model model){
        List<Niveau> niveaux = niveauService.getAll();
        List<Module> modules=moduleService.getAll();
        model.addAttribute("msg",message);
        model.addAttribute("modulesList",modules);
        model.addAttribute("niveauxList",niveaux);
        model.addAttribute("moduleModel",new ModuleModel());

        return "admin/module";
    }

    @RequestMapping(value = "addModule",method = RequestMethod.POST)
    public String addniveau(@ModelAttribute("moduleModel") ModuleModel moduleModel, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            // rq.setAttribute("typePerson", +person.getTypePerson());
            return "admin/module";
        }
        Module m = new Module();
        BeanUtils.copyProperties(moduleModel, m);
        moduleService.add(m);
        model.addAttribute("mgs","Module ajouter en success");
        return "redirect:/admin/modules";
    }

    @PostMapping("deletemodule")
    public String delete(HttpServletRequest rq, RedirectAttributes redirectAttributes){
        Long id=Long.valueOf(rq.getParameter("idModule"));
        moduleService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Module est supprimer avec success");
        return "redirect:/admin/modules";
    }

}
