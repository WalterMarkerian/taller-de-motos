package com.tallerDeMotos.motocicletas.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallerDeMotos.motocicletas.domain.enums.Marca;
import com.tallerDeMotos.ordenDeTrabajo.domain.dto.OrdenDeTrabajoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MotocicletaDTO {
    @Schema(description = "Identificador de la motocicleta", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty(value = "motocicletaId")
    @NotNull(message = "El id es requerido.")
    Long motocicletaId;
    @Schema(description = "Dominio de la moto", requiredMode = Schema.RequiredMode.REQUIRED, example = "AAA000")
    @JsonProperty(value = "dominio", required = true)
    @NotBlank(message = "La dominio es requerida.")
    String dominio;
    @Schema(description = "Marca de la moto", requiredMode = Schema.RequiredMode.REQUIRED, example = "YAMAHA")
    @JsonProperty(value = "marca", required = true)
    @NotBlank(message = "La marca de la moto es requerida.")
    Marca marca;
    @Schema(description = "Modelo de la moto", requiredMode = Schema.RequiredMode.REQUIRED, example = "MT-09")
    @JsonProperty(value = "modelo", required = true)
    @NotBlank(message = "El modelo de la moto es requerido.")
    String modelo;
    @Schema(description = "Cilindrada de la moto", example = "850cc")
    @JsonProperty(value = "cilindrada")
    String cilindrada;
    @Schema(description = "Número de chasis de la moto", example = "CH123456789")
    @JsonProperty(value = "chasis")
    String chasis;
    @Schema(description = "Kilometraje de la moto", example = "15000")
    @JsonProperty(value = "kilometraje")
    @NotNull(message = "El kilometraje es requerido.")
    Integer kilometraje;
    @Schema(description = "Fecha de alta de la moto", example = "2024-08-10T14:30:00")
    @JsonProperty(value = "altaMoto")
    @NotNull(message = "La fecha de alta es requerida.")
    LocalDate altaMoto;
    @Schema(description = "Identificador del cliente asociado a la motocicleta", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty(value = "clienteId")
    @NotNull(message = "El ID del cliente es requerido.")
    Long clienteId;
    @Schema(description = "Órdenes de trabajo asociadas a la moto", example = "[]", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty(value = "ordenesDeTrabajo", required = false)
    List<OrdenDeTrabajoDTO> ordenesDeTrabajo;
}
