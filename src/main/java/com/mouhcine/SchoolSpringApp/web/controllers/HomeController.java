package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Compte;
import com.mouhcine.SchoolSpringApp.dao.impl.CompteDaoCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @Autowired
    CompteDaoCustomImpl compteDaoCustom;

    @RequestMapping("/")
    public String index() {
        Compte compte = compteDaoCustom.searchByLogin("admin");
        System.out.println(compte);
        return "index";
    }
}
