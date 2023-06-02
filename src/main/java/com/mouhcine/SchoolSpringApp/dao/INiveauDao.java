package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INiveauDao extends JpaRepository<Niveau,Long> {
}
