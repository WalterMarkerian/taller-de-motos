package com.tallerDeMotos.cliente.domain.entity;
import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;
    private Long dni;
    private LocalDate fechaNacimiento;
    private LocalDate altaCliente;
    private String nombre;
    private String apellido;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;
    private String telefono;
    private String domicilio;

    // Relación uno a muchos con Motocicleta
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Motocicleta> motocicletas;
}