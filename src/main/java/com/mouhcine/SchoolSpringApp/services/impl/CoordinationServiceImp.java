package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Coordination;
import com.mouhcine.SchoolSpringApp.services.impl.CoordinationServiceImp;
import com.mouhcine.SchoolSpringApp.dao.ICoordinationDao;
import com.mouhcine.SchoolSpringApp.services.ICoordinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinationServiceImp implements ICoordinationService {
    @Autowired
    private ICoordinationDao coordinationDao;

    @Override
    public void add(Coordination m) {
        coordinationDao.save(m);
    }

    @Override
    public void update(Coordination m) {
        coordinationDao.save(m);
    }

    @Override
    public void delete(Long id) {
        coordinationDao.deleteById(id);
    }

    @Override
    public List<Coordination> getAll() {
        return coordinationDao.findAll();
    }

}
