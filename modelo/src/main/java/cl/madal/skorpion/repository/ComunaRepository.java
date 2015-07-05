package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Comuna;
import cl.madal.skorpion.modelo.Provincia;
import cl.madal.skorpion.modelo.Region;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *
 * @author Juan
 */
@Resource(name = "comunaRepository")
public interface ComunaRepository extends JpaRepository<Comuna, Long> {

    public Comuna findByNombreIgnoreCaseAndProvincia(String nombre, Provincia provincia);

    public List<Comuna> findByProvinciaRegion(Region region);
}
