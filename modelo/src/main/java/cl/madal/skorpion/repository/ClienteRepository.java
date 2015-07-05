package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Cliente;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
