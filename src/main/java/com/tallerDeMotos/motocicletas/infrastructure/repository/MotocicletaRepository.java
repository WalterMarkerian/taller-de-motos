package com.tallerDeMotos.motocicletas.infrastructure.repository;


import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotocicletaRepository extends JpaRepository<Motocicleta, String> {

    boolean existsByDominio(String dominio);
    boolean existsByMotocicletaId(Long motocicletaId);
    Optional<Motocicleta> findByMotocicletaId(Long motocicletaId);}
