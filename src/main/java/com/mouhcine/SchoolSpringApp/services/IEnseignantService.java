package com.mouhcine.SchoolSpringApp.services;


import com.mouhcine.SchoolSpringApp.bo.Enseignant;

import java.util.List;
import java.util.Optional;

public interface IEnseignantService {

    public void add(Enseignant f);
    public void update(Enseignant f);
    public void delete(Long id);
    public List<Enseignant> getAll();
    public Optional<Enseignant> getById(Long id);

}
