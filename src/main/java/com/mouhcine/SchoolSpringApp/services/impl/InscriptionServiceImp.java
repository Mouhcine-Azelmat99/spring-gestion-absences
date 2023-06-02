package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Inscription;
import com.mouhcine.SchoolSpringApp.bo.Niveau;
import com.mouhcine.SchoolSpringApp.dao.IInscriptionDao;
import com.mouhcine.SchoolSpringApp.services.IInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServiceImp implements IInscriptionService {
    @Autowired
    private IInscriptionDao inscriptionDao;

    @Override
    public void add(Inscription f) {
        inscriptionDao.save(f);
    }

    @Override
    public void update(Inscription f) {
        inscriptionDao.save(f);
    }

    @Override
    public void delete(Long id) {
        inscriptionDao.deleteById(id);
    }

    @Override
    public List<Inscription> getAll() {
        return inscriptionDao.findAll();
    }

    @Override
    public List<Inscription> getByNiveau(Niveau niveau) {
        return inscriptionDao.findByNiveau(niveau);
    }

}
