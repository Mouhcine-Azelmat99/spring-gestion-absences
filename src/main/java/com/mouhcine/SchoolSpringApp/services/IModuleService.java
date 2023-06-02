package com.mouhcine.SchoolSpringApp.services;


import com.mouhcine.SchoolSpringApp.bo.Module;

import java.util.List;

public interface IModuleService {
    public void add(Module f);
    public void update(Module f);
    public void delete(Long id);
    public List<Module> getAll();

}
