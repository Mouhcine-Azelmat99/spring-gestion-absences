package com.mouhcine.SchoolSpringApp.web.models;

import com.mouhcine.SchoolSpringApp.bo.Filiere;
import com.mouhcine.SchoolSpringApp.bo.Module;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NiveauModel {
    private Long idNiveau;

    private String alias;

    private String titre;
    private Filiere filiere;
    private List<Module> modules;



}
