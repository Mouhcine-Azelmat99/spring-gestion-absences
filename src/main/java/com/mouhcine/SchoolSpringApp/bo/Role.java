package com.mouhcine.SchoolSpringApp.bo;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String nomRole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Compte> comptes;

}
