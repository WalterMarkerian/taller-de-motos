package com.tallerDeMotos.ordenDeTrabajo.domain.entity;
import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDeTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_de_trabajo_id")
    private Long ordenDeTrabajoId;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Double monto;
    @Column(name = "alta_orden", nullable = false)
    private LocalDate altaOrden;
    @Column(name = "estado", nullable = false)
    private String estado; // Ejemplo: "Pendiente", "En Proceso", "Finalizada"

    // Relación muchos a uno con Motocicleta
    @ManyToOne
    @JoinColumn(name = "motocicleta_id", nullable = false) // Cada orden de trabajo está asociada a una motocicleta
    private Motocicleta motocicleta;
}