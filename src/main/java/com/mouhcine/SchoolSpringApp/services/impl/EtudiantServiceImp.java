package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Etudiant;
import com.mouhcine.SchoolSpringApp.dao.IEtudiantDao;
import com.mouhcine.SchoolSpringApp.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImp implements IEtudiantService {
    @Autowired
    private IEtudiantDao etudiantDao;

    @Override
    public void add(Etudiant f) {
        etudiantDao.save(f);
    }

    @Override
    public void update(Etudiant f) {
        etudiantDao.save(f);
    }

    @Override
    public void delete(Long id) {
        etudiantDao.deleteById(id);
    }

    @Override
    public List<Etudiant> getAll() {
        return etudiantDao.findAll();
    }

    @Override
    public Optional<Etudiant> getById(Long id) {
        return etudiantDao.findById(id);
    }

}
