package com.tallerDeMotos.cliente.infrastructure.repository;

import com.tallerDeMotos.cliente.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    void deleteByDni(Long dni);

    Optional<Cliente> findByDni(Long dni);

    boolean existsByDni(Long dni);
}