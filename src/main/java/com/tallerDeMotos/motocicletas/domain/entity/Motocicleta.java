package com.tallerDeMotos.motocicletas.domain.entity;
import com.tallerDeMotos.cliente.domain.entity.Cliente;
import com.tallerDeMotos.motocicletas.domain.enums.Marca;
import com.tallerDeMotos.ordenDeTrabajo.domain.entity.OrdenDeTrabajo;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Motocicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motocicleta_id")
    private Long motocicletaId;
    @Column(nullable = false, unique = true)
    private String dominio;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Marca marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = true)
    private String cilindrada;
    @Column(nullable = true)
    private String chasis;
    @Column(nullable = true)
    private Integer kilometraje;
    @Column(name = "alta_moto")
    private LocalDate altaMoto;

    // Relación muchos a uno con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) // Siempre debe pertenecer a un cliente
    private Cliente cliente;

    // Relación uno a muchos con OrdenDeTrabajo
    @OneToMany(mappedBy = "motocicleta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdenDeTrabajo> ordenesDeTrabajo;
}