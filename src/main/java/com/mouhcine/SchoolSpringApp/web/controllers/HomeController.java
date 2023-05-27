package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Compte;
import com.mouhcine.SchoolSpringApp.dao.impl.CompteDaoCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    CompteDaoCustomImpl compteDaoCustom;

    @RequestMapping("/")
    public String index(Model model) {
        Compte compte = compteDaoCustom.searchByLogin("admin");
        System.out.println(compte);
        return "index";
    }
}
