package com.mouhcine.SchoolSpringApp.services;

import com.mouhcine.SchoolSpringApp.bo.Utilisateur;
import com.mouhcine.SchoolSpringApp.utils.ExcelExporter;

import java.util.List;
import java.util.Optional;

public interface IUtilisateurService {

    public void addUtilisateur(Utilisateur utilisateur);
    public List<Utilisateur> getAll();
    public void deleteUtilisateur(Long id);

    public void updateUtilisateur(Utilisateur utilisateur);

    public Utilisateur getUtilisateurById(Long id);

    public Utilisateur getUtilisateurByCin(String cin);
    public Utilisateur getUtilisateurByNom(String nom);


    public ExcelExporter prepareUtilisateurExport(List<Utilisateur> users);


}
