package com.mouhcine.SchoolSpringApp.services;

import com.mouhcine.SchoolSpringApp.bo.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {
    public void add(Etudiant f);
    public void update(Etudiant f);
    public void delete(Long id);
    public List<Etudiant> getAll();
    public Optional<Etudiant> getById(Long id);

}
