package mx.edu.utez.Catalogo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "hijos") // CAMBIAR: nombre de la tabla (ej. "inscripciones" o "prestamos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hijo { // CAMBIAR: nombre de la entidad (ej. Inscripcion o Prestamo)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreSolicitante; // CAMBIAR/AGREGAR: datos de quien solicita (ej. nombreParticipante, correo, edad)
    private LocalDate fechaRegistro;    // CAMBIAR: nombre de fecha (ej. fechaInscripcion o fechaPrestamo)

    @Enumerated(EnumType.STRING)
    private HijoEstado estado;

    @ManyToOne
    @JoinColumn(name = "padre_id") // CAMBIAR: nombre de la llave foránea (ej. "curso_id" o "videojuego_id")
    private Padre padre;           // CAMBIAR: tipo y nombre del atributo (ej. private Curso curso;)
}
