package com.mouhcine.SchoolSpringApp.services;


import com.mouhcine.SchoolSpringApp.bo.Coordination;

import java.util.List;

public interface ICoordinationService {
    public void add(Coordination f);
    public void update(Coordination f);
    public void delete(Long id);
    public List<Coordination> getAll();

}
