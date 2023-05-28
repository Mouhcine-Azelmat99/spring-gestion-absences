package com.mouhcine.SchoolSpringApp.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilisateurs")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long idUtilisateur;

    private String nom;

    private String prenom;

    @Column(unique = true, nullable = true)
    private String cin;

    @Column(unique = true, nullable = true)
    private String email;

    @Column(nullable = true)
    private String telephone;

    @Column(nullable = true)
    private String nomArabe;

    @Column(nullable = true)
    private String prenomArabe;

    @JsonIgnore
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, targetEntity = Compte.class)
    private Set<Compte> comptes;

    @Override
    public String toString() {
        return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin
                + ", email=" + email + ", telephone=" + telephone + ", nomArabe=" + nomArabe + ", prenomArabe="
                + prenomArabe + ", photo=" + photo + "]";
    }

    public String findType(){
        return "Utilisateur";
    }
    public String getCne() {
        return "";
    }
    public String getSpecialite() {
        return "";
    }
    public String getGrade() {
        return "";
    }

}
