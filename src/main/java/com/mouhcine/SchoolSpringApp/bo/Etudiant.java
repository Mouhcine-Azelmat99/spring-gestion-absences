package com.mouhcine.SchoolSpringApp.bo;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "idEtudiant")
public class Etudiant extends Utilisateur {

	private String cne;

	private Date dateNaissance;

	@OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL , targetEntity = InscriptionAnnuelle.class)
	private List<Inscription> inscriptions;


	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@Override
	public String toString() {
		return "Etudiant [cne=" + cne + ", dateNaissance=" + dateNaissance + ", inscriptions=" + inscriptions + "]";
	}

	@Override
	public String findType(){
		return "Etudiant";
	}

	

}