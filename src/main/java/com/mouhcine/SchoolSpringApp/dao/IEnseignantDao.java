package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnseignantDao extends JpaRepository<Enseignant,Long> {

}
