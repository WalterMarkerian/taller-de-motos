package com.tallerDeMotos.motocicletas.infrastructure.repository;


import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotocicletaRepository extends JpaRepository<Motocicleta, Long> {
//    void deleteByPatente(String patente);
//
//    Optional<Motocicleta> findByPatente(String patente);
//
//    boolean existsByPatente(String patente);

}
