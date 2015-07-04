package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Region;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
@Resource(name = "regionRepository")
public interface RegionRepository extends JpaRepository<Region, Integer> {

    public Region findByNombreIgnoreCase(String nombre);
    
      public Region findByNumero(Integer numero);
    
    
}
