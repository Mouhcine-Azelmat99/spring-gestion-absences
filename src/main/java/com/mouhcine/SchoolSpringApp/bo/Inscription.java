package com.mouhcine.SchoolSpringApp.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscription;

    private int annee;
    private int etat;

    @ManyToOne
    @JoinColumn(name = "idNiveau")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "idEtudiant")
    private Etudiant etudiant;
}
