package com.mouhcine.SchoolSpringApp.dao;


import com.mouhcine.SchoolSpringApp.bo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Long> , GenericJpa<Role, Long>{

}
