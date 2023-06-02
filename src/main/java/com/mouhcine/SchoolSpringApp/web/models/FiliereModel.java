package com.mouhcine.SchoolSpringApp.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FiliereModel {
    private Long idFiliere;

    private String titreFiliere;

    private String codeFiliere;

    private int anneeaccreditation;

    private int anneeFinaccreditation;

}
