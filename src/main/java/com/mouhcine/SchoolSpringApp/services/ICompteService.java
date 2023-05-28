package com.mouhcine.SchoolSpringApp.services;


import com.mouhcine.SchoolSpringApp.bo.Compte;
import com.mouhcine.SchoolSpringApp.bo.Role;
import com.mouhcine.SchoolSpringApp.utils.ExcelExporter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICompteService {
	
	public List<Role> getAllRoles();
	
	public List<Compte> getAllAccounts();

	
	public Compte getAccountByUserName(String login);
	
	public String createUser(Long idRole, Long idPerson);
	
	public ExcelExporter prepareCompteExport(List<Compte> comptes) ;
}
