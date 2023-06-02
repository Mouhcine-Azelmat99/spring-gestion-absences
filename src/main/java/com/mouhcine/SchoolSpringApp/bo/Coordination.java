package com.mouhcine.SchoolSpringApp.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoordination;

    private String dateDebut;
    private String dateFin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idFiliere")
    private Filiere filiere;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idEnseignant")
    private Enseignant coordinateur;
}
