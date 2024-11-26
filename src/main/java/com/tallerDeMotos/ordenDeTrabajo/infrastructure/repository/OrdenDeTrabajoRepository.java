package com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository;

import com.tallerDeMotos.ordenDeTrabajo.domain.entity.OrdenDeTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajo, Long> {
    boolean existsByOrdenDeTrabajoId(Long ordenDeTrabajoId);
//    Optional<OrdenDeTrabajo> findByOrdenDeTrabajoId(Long ordenDeTrabajoId);
}
