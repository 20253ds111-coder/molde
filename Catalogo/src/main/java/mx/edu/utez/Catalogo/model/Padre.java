package mx.edu.utez.Catalogo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "padres") // CAMBIAR: nombre de la tabla en plural (ej. "cursos" o "videojuegos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Padre { // CAMBIAR: nombre de la entidad (ej. Curso o Videojuego)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // CAMBIAR/AGREGAR: atributos propios (ej. titulo, plataforma, descripcion, fechaInicio)

    @Enumerated(EnumType.STRING)
    private PadreEstado estado; // CAMBIAR: si el examen usa boolean, pon: private boolean disponible;
}
