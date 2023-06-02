package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Compte;
import com.mouhcine.SchoolSpringApp.bo.Role;
import com.mouhcine.SchoolSpringApp.bo.Utilisateur;
import com.mouhcine.SchoolSpringApp.dao.ICompteDao;
import com.mouhcine.SchoolSpringApp.dao.IRoleDao;
import com.mouhcine.SchoolSpringApp.dao.IUtilisateurDao;
import com.mouhcine.SchoolSpringApp.services.ICompteService;
import com.mouhcine.SchoolSpringApp.utils.ExcelExporter;
import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {

	@Autowired
	private ICompteDao userDao;

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IUtilisateurDao personDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Role> getAllRoles() {
		return roleDao.findAll();
	}

	public List<Compte> getAllAccounts() {
		return userDao.findAll();
	}

	public String createUser(Long idRole, Long idPerson) {

		// récupérer la personne de la base de données
		Utilisateur person = personDao.getById(idPerson);

		// Créer le compte
		Compte userAccount = new Compte();

		// determiner la personne
		userAccount.setProprietaire(person);
		Role role = roleDao.getById(idRole);
		System.out.println("role +"+role+"  utilisateur = "+person);
		// Affecter le role
		userAccount.setRole(role);

		// génrer le mot de passe aléatoirement
		String generatedPass = generatePassayPassword();

		// hachage du mot de passe + gain de sel
		String encodedPass = passwordEncoder.encode(generatedPass);

		// affecter ce mot de passe
		userAccount.setPassword(encodedPass);

		// On construit un login de type "nom+prenom " s'il est dispo
		String login = person.getNom() + person.getPrenom();

		Compte account = userDao.searchByLogin(login);

//		Login must be unique else will be duplicate by number
		if (account == null) {

			userAccount.setLogin(login);

			// Créer le compte
			userDao.save(userAccount);
			return generatedPass;
		}

		int i = 0;

		// sinon, on cherche un login de type nom+prenom+"_"+ entier
		while (true) {

			login = person.getNom() + person.getPrenom() + "_" + i;
			account = userDao.searchByLogin(login);
			if (account == null) {
				userAccount.setLogin(login);

				// Créer le compte
				userDao.save(userAccount);
				return generatedPass;
			}

			i++;
		}
	}

	public ExcelExporter prepareCompteExport(List<Compte> comptes) {
		String[] columnNames = new String[] { "Login", "Rôle", "Nom & Prénom" };
		String[][] data = new String[comptes.size()][3];

		int i = 0;
		for (Compte u : comptes) {
			data[i][0] = u.getLogin();
			data[i][1] = u.getRole().getNomRole();
			data[i][2] = u.getProprietaire().getNom() + " " + u.getProprietaire().getPrenom();
			i++;
		}

		return new ExcelExporter(columnNames, data, "comptes");

	}

	// génère le mot de passe. Il se base sur Passay
	public String generatePassayPassword() {
		CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);

		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = passwordGenerator.generatePassword(10, digits);

		return password;
	}

	@Override
	public Compte getAccountByUserName(String login) {
		return userDao.searchByLogin(login);
	}

}
