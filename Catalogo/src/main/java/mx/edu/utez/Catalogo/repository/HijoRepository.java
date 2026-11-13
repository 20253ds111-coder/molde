package mx.edu.utez.Catalogo.repository;

import mx.edu.utez.Catalogo.model.Hijo;
import mx.edu.utez.Catalogo.model.HijoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HijoRepository extends JpaRepository<Hijo, Long> { // CAMBIAR: Hijo por tu entidad

    List<Hijo> findByEstado(HijoEstado estado);

    // OPCIONAL (agregar solo si el examen pide buscar por correo o por ID del padre):
    // List<Hijo> findByCorreo(String correo);
    // List<Hijo> findByPadreId(Long padreId);
}
