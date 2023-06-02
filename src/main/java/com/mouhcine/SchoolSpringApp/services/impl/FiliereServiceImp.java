package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Filiere;
import com.mouhcine.SchoolSpringApp.dao.IFiliereDao;
import com.mouhcine.SchoolSpringApp.services.IFiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereServiceImp implements IFiliereService {

    @Autowired
    private IFiliereDao filiereDao;
    @Override
    public void add(Filiere f) {
        filiereDao.save(f);
    }

    @Override
    public void update(Filiere f) {
        filiereDao.save(f);
    }

    @Override
    public void delete(Long id) {
        filiereDao.deleteById(id);
    }

    @Override
    public List<Filiere> getAll() {
        return filiereDao.findAll();
    }

    @Override
    public Optional<Filiere> getById(Long id) {
        return filiereDao.findById(id);
    }
}
