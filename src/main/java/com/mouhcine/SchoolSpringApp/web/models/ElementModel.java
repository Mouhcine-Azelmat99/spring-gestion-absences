package com.mouhcine.SchoolSpringApp.web.models;

import com.mouhcine.SchoolSpringApp.bo.Module;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ElementModel {
    private Long idMatiere;
    private String nom;
    private String code;
    private double currentCoefficient;
    private Module module;

}
