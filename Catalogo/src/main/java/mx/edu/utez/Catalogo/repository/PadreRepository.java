package mx.edu.utez.Catalogo.repository;

import mx.edu.utez.Catalogo.model.Padre;
import mx.edu.utez.Catalogo.model.PadreEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PadreRepository extends JpaRepository<Padre, Long> { // CAMBIAR: Padre por tu entidad

    List<Padre> findByEstado(PadreEstado estado); // CAMBIAR: si usas boolean, cambia esta línea por:
    // List<Videojuego> findByDisponibleTrue();
}