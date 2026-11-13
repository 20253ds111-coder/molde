package mx.edu.utez.Catalogo.controller;

import mx.edu.utez.Catalogo.controller.dto.CrearHijoDTO;
import mx.edu.utez.Catalogo.controller.dto.CrearPadreDTO;
import mx.edu.utez.Catalogo.model.Hijo;
import mx.edu.utez.Catalogo.model.HijoEstado;
import mx.edu.utez.Catalogo.model.Padre;
import mx.edu.utez.Catalogo.service.MyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controlador")
@CrossOrigin("*")
public class MyController {

    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    // 1. Registrar Padre (10 pts)
    @PostMapping("/padre") // CAMBIAR: ruta (ej. "/curso" o "/videojuego")
    public ResponseEntity<Padre> registrarPadre(@RequestBody @Valid CrearPadreDTO payload) {
        return ResponseEntity.status(201).body(service.registrarPadre(payload));
    }

    // 2. Listar todos los Padres (5 pts)
    @GetMapping("/padre") // CAMBIAR: ruta
    public ResponseEntity<List<Padre>> listarTodos() {
        return ResponseEntity.ok(service.listarTodosPadres());
    }

    // 3. Listar Padres disponibles (5 pts)
    @GetMapping("/padre/disponibles") // CAMBIAR: ruta
    public ResponseEntity<List<Padre>> listarDisponibles() {
        return ResponseEntity.ok(service.listarPadresDisponibles());
    }

    // 4. Registrar Hijo (30 pts)
    @PostMapping("/hijo") // CAMBIAR: ruta (ej. "/inscripcion" o "/prestamo")
    public ResponseEntity<Hijo> registrarHijo(@RequestBody @Valid CrearHijoDTO payload) {
        return ResponseEntity.status(201).body(service.registrarHijo(payload));
    }

    // 5. Cancelar o Devolver Hijo (20 - 25 pts)
    @PutMapping("/hijo/cancelar/{id}") // CAMBIAR: ruta (ej. "/inscripcion/cancelar/{id}" o "/prestamo/devolver/{id}")
    public ResponseEntity<Hijo> cancelarODevolver(@PathVariable Long id) {
        return ResponseEntity.ok(service.cancelarODevolver(id));
    }

    // 6. Consultar Hijos por estado (5 pts)
    @GetMapping("/hijo/estado/{estado}") // CAMBIAR: ruta
    public ResponseEntity<List<Hijo>> listarPorEstado(@PathVariable HijoEstado estado) {
        return ResponseEntity.ok(service.listarHijosPorEstado(estado));
    }
}
