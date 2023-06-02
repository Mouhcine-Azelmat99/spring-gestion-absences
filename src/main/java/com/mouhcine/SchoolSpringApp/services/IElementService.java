package com.mouhcine.SchoolSpringApp.services;


import com.mouhcine.SchoolSpringApp.bo.Element;

import java.util.List;

public interface IElementService {
    public void add(Element f);
    public void update(Element f);
    public void delete(Long id);
    public List<Element> getAll();

}
