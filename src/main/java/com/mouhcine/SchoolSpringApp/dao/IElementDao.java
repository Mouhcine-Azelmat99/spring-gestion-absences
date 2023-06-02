package com.mouhcine.SchoolSpringApp.dao;

import com.mouhcine.SchoolSpringApp.bo.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IElementDao extends JpaRepository<Element,Long> {
}
