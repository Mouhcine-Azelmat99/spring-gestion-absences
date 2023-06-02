package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Enseignant;
import com.mouhcine.SchoolSpringApp.dao.IEnseignantDao;
import com.mouhcine.SchoolSpringApp.services.IEnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantServiceImp implements IEnseignantService {

    @Autowired
    private IEnseignantDao enseignantDao;

    @Override
    public void add(Enseignant e) {
        enseignantDao.save(e);
    }

    @Override
    public void update(Enseignant e) {
        enseignantDao.save(e);
    }

    @Override
    public void delete(Long id) {
        enseignantDao.deleteById(id);
    }

    @Override
    public List<Enseignant> getAll() {
        return enseignantDao.findAll();
    }

    @Override
    public Optional<Enseignant> getById(Long id) {
        return enseignantDao.findById(id);
    }
}
