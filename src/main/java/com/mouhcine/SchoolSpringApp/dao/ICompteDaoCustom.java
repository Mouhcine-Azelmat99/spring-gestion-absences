package com.mouhcine.SchoolSpringApp.dao;


import com.mouhcine.SchoolSpringApp.bo.Compte;

public interface ICompteDaoCustom {
	public Compte searchByLogin(String username);

}
