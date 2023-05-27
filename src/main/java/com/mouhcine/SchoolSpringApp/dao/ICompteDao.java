package com.mouhcine.SchoolSpringApp.dao;


import com.mouhcine.SchoolSpringApp.bo.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteDao extends JpaRepository<Compte, Long>,
        ICompteDaoCustom , GenericJpa<Compte, Long> {

}
