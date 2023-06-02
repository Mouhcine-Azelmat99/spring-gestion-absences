package com.mouhcine.SchoolSpringApp.web.models;

import com.mouhcine.SchoolSpringApp.bo.Element;
import com.mouhcine.SchoolSpringApp.bo.Filiere;
import com.mouhcine.SchoolSpringApp.bo.Module;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ModuleModel {
    private Long idModule;

    private String titre;
    private String code;

    private List<Element> elements;
    private Niveau niveau;

}
