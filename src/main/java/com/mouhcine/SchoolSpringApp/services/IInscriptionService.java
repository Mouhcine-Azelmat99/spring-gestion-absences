package com.mouhcine.SchoolSpringApp.services;

import com.mouhcine.SchoolSpringApp.bo.Inscription;
import com.mouhcine.SchoolSpringApp.bo.Niveau;

import java.util.List;

public interface IInscriptionService {
    public void add(Inscription f);
    public void update(Inscription f);
    public void delete(Long id);
    public List<Inscription> getAll();

    List<Inscription> getByNiveau(Niveau niveau);


}
