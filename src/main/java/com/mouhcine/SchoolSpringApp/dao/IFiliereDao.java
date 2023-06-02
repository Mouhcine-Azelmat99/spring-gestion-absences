package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFiliereDao extends JpaRepository<Filiere,Long> {
}
