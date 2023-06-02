package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModuleDao extends JpaRepository<Module,Long> {
}
