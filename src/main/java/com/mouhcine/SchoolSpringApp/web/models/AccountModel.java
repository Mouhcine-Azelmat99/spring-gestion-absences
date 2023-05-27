package com.mouhcine.SchoolSpringApp.web.models;

//Classe model utilisé dans la partie web
// pour recevoir les données de la vue 
//utilisée pour créer les comptes
//C'est une classe non persistante
public class AccountModel {
	
	private String username;
	
	private String password;
	
	private Long roleId;
	
	private Long utilisateurId;
	
	
	public AccountModel() {
	}

	public AccountModel(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	
	public AccountModel(Long roleId, Long utilisateurId) {
		this.roleId = roleId;
		this.utilisateurId = utilisateurId;
	}

	public AccountModel(String username, String password, Long roleId, Long utilisateurId) {
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.utilisateurId = utilisateurId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long personId) {
		this.utilisateurId = utilisateurId;
	}

	
	
	
}
