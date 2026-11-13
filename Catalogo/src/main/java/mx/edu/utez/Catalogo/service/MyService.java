package mx.edu.utez.Catalogo.service;

import mx.edu.utez.Catalogo.controller.dto.CrearHijoDTO;
import mx.edu.utez.Catalogo.controller.dto.CrearPadreDTO;
import mx.edu.utez.Catalogo.exception.CustomException;
import mx.edu.utez.Catalogo.model.*;
import mx.edu.utez.Catalogo.repository.HijoRepository;
import mx.edu.utez.Catalogo.repository.PadreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MyService {

    private final PadreRepository padreRepository; // CAMBIAR: nombres de repositorios
    private final HijoRepository hijoRepository;

    public MyService(PadreRepository padreRepository, HijoRepository hijoRepository) {
        this.padreRepository = padreRepository;
        this.hijoRepository = hijoRepository;
    }
    // 1. REGISTRAR PADRE / CATÁLOGO (10 puntos)
    public Padre registrarPadre(CrearPadreDTO payload) {
        Padre padre = new Padre();
        padre.setNombre(payload.getNombre()); // CAMBIAR: setear los atributos del DTO
        padre.setEstado(PadreEstado.DISPONIBLE); // CAMBIAR: si es boolean, poner: padre.setDisponible(true);
        return padreRepository.save(padre);
    }

    // 2. LISTAR TODOS LOS PADRES (5 puntos)
    public List<Padre> listarTodosPadres() {
        return padreRepository.findAll();
    }

    // 3. LISTAR PADRES DISPONIBLES (5 puntos)
    public List<Padre> listarPadresDisponibles() {
        return padreRepository.findByEstado(PadreEstado.DISPONIBLE); // CAMBIAR: si es boolean, usar findByDisponibleTrue()
    }

    // 4. REGISTRAR HIJO / MOVIMIENTO PRINCIPAL (30 puntos)
    public Hijo registrarHijo(CrearHijoDTO payload) {
        Padre padre = padreRepository.findById(payload.getIdPadre())
                .orElseThrow(() -> new CustomException("El registro padre no existe"));

        // Validar disponibilidad (CAMBIAR si usa boolean: if (!padre.isDisponible()) )
        if (padre.getEstado() != PadreEstado.DISPONIBLE) {
            throw new CustomException("No se encuentra disponible");
        }

        // OPCIONAL: Si el examen pide marcar el padre como ocupado al prestarlo (como en Videojuegos):
        // padre.setDisponible(false);
        // padreRepository.save(padre);

        Hijo hijo = new Hijo();
        hijo.setNombreSolicitante(payload.getNombreSolicitante()); // CAMBIAR: setear demás datos del DTO
        hijo.setFechaRegistro(LocalDate.now());
        hijo.setEstado(HijoEstado.ACTIVO);
        hijo.setPadre(padre);

        return hijoRepository.save(hijo);
    }

    // 5. CANCELAR O DEVOLVER HIJO (20 - 25 puntos)
    public Hijo cancelarODevolver(Long idHijo) {
        Hijo hijo = hijoRepository.findById(idHijo)
                .orElseThrow(() -> new CustomException("El registro no existe"));

        if (hijo.getEstado() != HijoEstado.ACTIVO) {
            throw new CustomException("Solo se puede modificar un registro activo");
        }

        hijo.setEstado(HijoEstado.CANCELADO); // CAMBIAR: por CANCELADO o DEVUELTO según el endpoint que elijas

        // OPCIONAL: Si el examen pide liberar el padre al cancelar/devolver (como en Videojuegos):
        // Padre padre = hijo.getPadre();
        // padre.setDisponible(true);
        // padreRepository.save(padre);

        return hijoRepository.save(hijo);
    }

    // 6. CONSULTAR HIJOS POR ESTADO (5 puntos)
    public List<Hijo> listarHijosPorEstado(HijoEstado estado) {
        return hijoRepository.findByEstado(estado);
    }
}