package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IUtilisateurDao extends JpaRepository<Utilisateur,Long> , GenericJpa<Utilisateur, Long> {
    public Utilisateur findByCin(String cin);
}
