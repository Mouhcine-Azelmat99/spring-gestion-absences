package com.mouhcine.SchoolSpringApp.bo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseignant")
public class Enseignant extends Utilisateur {


	
	private String specialite;

	@JsonIgnore
	@OneToMany(mappedBy = "coordinateur", cascade = CascadeType.ALL, targetEntity = Coordination.class)
	private Set<Coordination> coordinations;

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String findType(){
		return "Enseignant";
	}

	public Set<Coordination> getCoordinations() {
		return coordinations;
	}


}