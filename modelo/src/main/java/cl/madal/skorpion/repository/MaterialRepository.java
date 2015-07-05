package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Material;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "materialRepository")
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
