package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Element;
import com.mouhcine.SchoolSpringApp.bo.Module;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import com.mouhcine.SchoolSpringApp.services.IElementService;
import com.mouhcine.SchoolSpringApp.services.IModuleService;
import com.mouhcine.SchoolSpringApp.services.INiveauService;
import com.mouhcine.SchoolSpringApp.web.models.ElementModel;
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
public class ElementeController {
    @Autowired
    IElementService elementService;

    @Autowired
    IModuleService moduleService;
    @GetMapping("elements")
    public String index(@ModelAttribute("message") String message, Model model){
        List<Element> elements = elementService.getAll();
        List<Module> modules=moduleService.getAll();
        model.addAttribute("msg",message);
        model.addAttribute("modulesList",modules);
        model.addAttribute("elementsList",elements);
        model.addAttribute("elementModel",new ElementModel());

        return "admin/element";
    }

    @RequestMapping(value = "addElement",method = RequestMethod.POST)
    public String addniveau(@ModelAttribute("elementModel") ElementModel elementModel, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            // rq.setAttribute("typePerson", +person.getTypePerson());
            return "admin/element";
        }
        Element element = new Element();
        BeanUtils.copyProperties(elementModel, element);
        elementService.add(element);
        model.addAttribute("mgs","Element ajouter en success");
        return "redirect:/admin/elements";
    }

    @PostMapping("deleteelement")
    public String delete(HttpServletRequest rq, RedirectAttributes redirectAttributes){
        Long id=Long.valueOf(rq.getParameter("idMatiere"));
        elementService.delete(id);
        redirectAttributes.addFlashAttribute("message", "element est supprimer avec success");
        return "redirect:/admin/elements";
    }

}
