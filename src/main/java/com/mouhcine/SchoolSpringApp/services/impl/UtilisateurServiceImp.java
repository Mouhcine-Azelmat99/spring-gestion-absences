package com.mouhcine.SchoolSpringApp.services.impl;


import com.mouhcine.SchoolSpringApp.bo.Utilisateur;
import com.mouhcine.SchoolSpringApp.dao.IUtilisateurDao;
import com.mouhcine.SchoolSpringApp.services.IUtilisateurService;
import com.mouhcine.SchoolSpringApp.utils.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurDao.getById(id);
    }

    @Override
    public Utilisateur getUtilisateurByCin(String cin) {
        return utilisateurDao.getEntityByColValue(Utilisateur.class, "cin", cin);
    }

    @Override
    public ExcelExporter prepareUtilisateurExport(List<Utilisateur> users) {
        String[] columnNames = new String[] { "Nom", "Prénom", "CIN", "Email", "Télé" };
        String[][] data = new String[users.size()][5];

        int i = 0;
        for (Utilisateur u : users) {
            data[i][0] = u.getNom();
            data[i][1] = u.getPrenom();
            data[i][2] = u.getCin();
            data[i][3] = u.getEmail();
            data[i][4] = u.getTelephone();
            i++;
        }

        return new ExcelExporter(columnNames, data, "persons");
    }
}
