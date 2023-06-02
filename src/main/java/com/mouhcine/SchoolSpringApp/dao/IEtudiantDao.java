package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Etudiant;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtudiantDao extends JpaRepository<Etudiant,Long> {
}
