package com.mouhcine.SchoolSpringApp.dao.impl;


import com.mouhcine.SchoolSpringApp.bo.Compte;
import com.mouhcine.SchoolSpringApp.dao.ICompteDaoCustom;
import org.springframework.stereotype.Repository;

@Repository
public class CompteDaoCustomImpl extends GenericJpaImpl<Compte, Long> implements ICompteDaoCustom {

	
	public Compte searchByLogin(String login) {
		return getEntityByColValue(Compte.class, "login", login);
	}
}
