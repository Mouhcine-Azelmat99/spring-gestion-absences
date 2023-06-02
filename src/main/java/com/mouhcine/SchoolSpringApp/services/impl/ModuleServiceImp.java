package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Module;
import com.mouhcine.SchoolSpringApp.dao.IModuleDao;
import com.mouhcine.SchoolSpringApp.services.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImp implements IModuleService {
    @Autowired
    private IModuleDao moduleDao;

    @Override
    public void add(Module m) {
        moduleDao.save(m);
    }

    @Override
    public void update(Module m) {
        moduleDao.save(m);
    }

    @Override
    public void delete(Long id) {
        moduleDao.deleteById(id);
    }

    @Override
    public List<Module> getAll() {
        return moduleDao.findAll();
    }

}
