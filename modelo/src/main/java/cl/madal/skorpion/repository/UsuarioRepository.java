package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Usuario;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
