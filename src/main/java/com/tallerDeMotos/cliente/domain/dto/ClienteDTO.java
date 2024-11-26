package com.tallerDeMotos.cliente.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.motocicletas.domain.dto.MotocicletaDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @Schema(hidden = true)
    @JsonProperty(value = "clienteId")
    Long clienteId;
    @Schema(description = "Dni del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1234567890")
    @NotNull(message = "El DNI es requerido.")
    Long dni;
    @Schema(description = "Fecha de nacimiento del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1990-05-15")
    @NotNull(message = "La fecha de nacimiento es requerida.")
    LocalDate fechaNacimiento;
    @Schema(description = "Fecha de alta del cliente", example = "2024-08-10")
    LocalDate altaCliente;
    @Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Juan")
    @NotBlank(message = "El nombre es requerido.")
    String nombre;
    @Schema(description = "Apellido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "De Los Palotes")
    @NotBlank(message = "El apellido es requerido.")
    String apellido;
    @Schema(description = "Género del cliente", example = "MASCULINO")
    @NotNull(message = "El género es requerido.")
    Genero genero;
    @Schema(description = "Teléfono del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "+54 9 11 1234 4321")
    @NotBlank(message = "El teléfono es requerido.")
    String telefono;
    @Schema(description = "Domicilio del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Calle Falsa 123")
    @NotBlank(message = "El domicilio es requerido.")
    String domicilio;
    @Schema(
            description = "Lista de motocicletas del cliente",
            example = "[{ \"patente\": \"AAs3d0A00\", \"marca\": \"YAMAHA\", \"modelo\": \"MT-09\", \"cilindrada\": \"850cc\"," +
                    " \"chasis\": \"CH123456789\", \"kilometraje\": 15000, \"altaMoto\": \"2024-08-10\", " +
                    "\"ordenesDeTrabajo\": [{ \"items\": 3, \"descripcion\": \"Cambio de aceite\", \"monto\": 150.75, \"altaOrden\": \"2024-08-10\" }] }]")
    @NotNull(message = "La lista de motocicletas no puede ser nula.")
    List<MotocicletaDTO> motocicletas;
}