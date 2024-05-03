package com.project.cine.repository;

import com.project.cine.model.Proyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionRepository extends JpaRepository<Proyeccion, Long> {
}
