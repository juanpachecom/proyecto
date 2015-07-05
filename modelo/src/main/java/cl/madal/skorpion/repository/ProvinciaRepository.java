package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Provincia;
import cl.madal.skorpion.modelo.Region;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "provinciaRepository")
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    public Provincia findByNombreIgnoreCaseAndRegion(String nombre, Region region);
}
