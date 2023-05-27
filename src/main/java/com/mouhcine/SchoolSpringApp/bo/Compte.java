package com.mouhcine.SchoolSpringApp.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Compte{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

    private String login;

    private String password;

    private boolean disconnectAccount;

    private boolean accepteDemandeAutorisationAbsence;

    private boolean affichePhoto;

    private boolean afficheEmail;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur proprietaire;

    @Override
    public String toString() {
        return "Compte [idCompte=" + idCompte + ", accountNonExpired=" + accountNonExpired + ", accountNonLocked="
                + accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled
                + ", login=" + login + ", password=" + password + ", disconnectAccount=" + disconnectAccount
                + ", accepteDemandeAutorisationAbsence=" + accepteDemandeAutorisationAbsence + ", affichePhoto="
                + affichePhoto + ", afficheEmail=" + afficheEmail + ", role=" + role + "]";
    }


}
