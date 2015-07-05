package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Rol;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "rolRepository")
public interface RolRepository extends JpaRepository<Rol, Long> {

}
