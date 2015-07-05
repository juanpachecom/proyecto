package cl.madal.skorpion.repository;

import cl.madal.skorpion.modelo.Pedido;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juan
 */
@Resource(name = "pedidoRepository")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
