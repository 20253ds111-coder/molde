package mx.edu.utez.Catalogo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrearPadreDTO { // CAMBIAR: nombre (ej. CrearCursoDTO o CrearVideojuegoDTO)

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre; // CAMBIAR/AGREGAR: campos que pida el registro (ej. titulo, plataforma, fechas)
}
