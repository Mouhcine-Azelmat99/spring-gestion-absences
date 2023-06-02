package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Coordination;
import com.mouhcine.SchoolSpringApp.bo.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoordinationDao extends JpaRepository<Coordination,Long> {
}
