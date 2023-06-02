package com.mouhcine.SchoolSpringApp.services;

import com.mouhcine.SchoolSpringApp.bo.Niveau;

import java.util.List;
import java.util.Optional;

public interface INiveauService {
    public void add(Niveau f);
    public void update(Niveau f);
    public void delete(Long id);
    public List<Niveau> getAll();
    public Optional<Niveau> getById(Long id);

}
