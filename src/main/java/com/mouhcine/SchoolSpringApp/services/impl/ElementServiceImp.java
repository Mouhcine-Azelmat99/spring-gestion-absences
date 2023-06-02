package com.mouhcine.SchoolSpringApp.services.impl;

import com.mouhcine.SchoolSpringApp.bo.Element;
import com.mouhcine.SchoolSpringApp.dao.IElementDao;
import com.mouhcine.SchoolSpringApp.services.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementServiceImp implements IElementService {
    @Autowired
    private IElementDao elementDao;

    @Override
    public void add(Element m) {
        elementDao.save(m);
    }

    @Override
    public void update(Element m) {
        elementDao.save(m);
    }

    @Override
    public void delete(Long id) {
        elementDao.deleteById(id);
    }

    @Override
    public List<Element> getAll() {
        return elementDao.findAll();
    }

}
