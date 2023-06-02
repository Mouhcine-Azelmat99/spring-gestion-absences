package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Niveau;
import com.mouhcine.SchoolSpringApp.dao.INiveauDao;
import com.mouhcine.SchoolSpringApp.services.INiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauServiceImp implements INiveauService {
    @Autowired
    private INiveauDao niveauDao;

    @Override
    public void add(Niveau f) {
        niveauDao.save(f);
    }

    @Override
    public void update(Niveau f) {
        niveauDao.save(f);
    }

    @Override
    public void delete(Long id) {
        niveauDao.deleteById(id);
    }

    @Override
    public List<Niveau> getAll() {
        return niveauDao.findAll();
    }

    @Override
    public Optional<Niveau> getById(Long id) {
        return niveauDao.findById(id);
    }

}
