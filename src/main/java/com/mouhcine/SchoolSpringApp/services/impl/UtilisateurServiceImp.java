package com.mouhcine.SchoolSpringApp.services.impl;


import com.mouhcine.SchoolSpringApp.bo.Utilisateur;
import com.mouhcine.SchoolSpringApp.dao.IUtilisateurDao;
import com.mouhcine.SchoolSpringApp.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImp implements IUtilisateurService {

    @Autowired
    private IUtilisateurDao utilisateurDao;


    @Override
    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurDao.save(utilisateur);
    }

    @Override
    public List<Utilisateur> getAll() {
        return utilisateurDao.findAll();
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurDao.deleteById(id);
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurDao.save(utilisateur);
    }

    @Override
    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurDao.findById(id);
    }

    @Override
    public Utilisateur getUtilisateurByCin(String cin) {
        return utilisateurDao.findByCin(cin);
    }
}
