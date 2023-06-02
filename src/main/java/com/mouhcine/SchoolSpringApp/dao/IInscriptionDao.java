package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Inscription;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInscriptionDao extends JpaRepository<Inscription,Long> {

    List<Inscription> findByNiveau(Niveau niveau);

}
