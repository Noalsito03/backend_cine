package com.project.cine.repository;

import com.project.cine.model.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
}
