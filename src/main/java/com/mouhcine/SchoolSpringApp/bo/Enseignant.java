package com.mouhcine.SchoolSpringApp.bo;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@PrimaryKeyJoinColumn(name = "idEnseighant")
public class Enseignant extends Utilisateur {


	
	private String specialite;


	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}





}