package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.MuebleMaterial;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "mueblematerialRepository")
public interface MuebleMaterialRepository extends JpaRepository<MuebleMaterial, Long> {

}
