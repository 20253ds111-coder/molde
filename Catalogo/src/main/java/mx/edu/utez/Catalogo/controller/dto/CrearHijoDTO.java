package mx.edu.utez.Catalogo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrearHijoDTO { // CAMBIAR: nombre (ej. InscribirParticipanteDTO o CrearPrestamoDTO)

    @NotNull(message = "El ID es obligatorio")
    private Long idPadre; // CAMBIAR: nombre (ej. idCurso o idVideojuego)

    @NotBlank(message = "El nombre es obligatorio")
    private String nombreSolicitante; // CAMBIAR/AGREGAR: otros campos con @Email o @Positive si los piden
}
