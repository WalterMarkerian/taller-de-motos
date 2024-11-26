package com.tallerDeMotos.ordenDeTrabajo.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallerDeMotos.ordenDeTrabajo.domain.enums.Estado;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDeTrabajoDTO {
    @Schema(description = "Identificador de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty(value = "ordenDeTrabajoId")
    @NotNull(message = "El id es requerido.")
    Long ordenDeTrabajoId;
    @Schema(description = "Descripción de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cambio de aceite")
    @JsonProperty(value = "descripcion", required = true)
    @NotNull(message = "La descripción es requerida.")
    String descripcion;
    @Schema(description = "Monto de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "150.75")
    @JsonProperty(value = "monto", required = true)
    @NotNull(message = "El monto es requerido.")
    Double monto;
    @Schema(description = "Fecha de alta de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-08-10T14:30:00")
    @JsonProperty(value = "altaOrden", required = true)
    @NotNull(message = "La fecha de alta es requerida.")
    LocalDate altaOrden;
    @Schema(description = "Estado de alta de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pendiente")
    @JsonProperty(value = "estado", required = true)
    @NotNull(message = "El estado de la orden de trabajo es requerida.")
    Estado estado;
    @Schema(description = "Identificador de la motocicleta asociada a la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty(value = "motocicletaId")
    @NotNull(message = "El identificador de la motocicleta es requerido.")
    Long motocicletaId;
}
