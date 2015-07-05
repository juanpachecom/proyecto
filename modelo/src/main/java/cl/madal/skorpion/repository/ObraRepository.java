package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Obra;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "obraRepository")
public interface ObraRepository extends JpaRepository<Obra, Long> {

}
