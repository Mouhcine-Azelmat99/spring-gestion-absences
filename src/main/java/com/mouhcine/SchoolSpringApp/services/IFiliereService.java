package com.mouhcine.SchoolSpringApp.services;


import com.mouhcine.SchoolSpringApp.bo.Filiere;

import java.util.List;
import java.util.Optional;

public interface IFiliereService {

    public void add(Filiere f);
    public void update(Filiere f);
    public void delete(Long id);
    public List<Filiere> getAll();
    public Optional<Filiere> getById(Long id);

}
