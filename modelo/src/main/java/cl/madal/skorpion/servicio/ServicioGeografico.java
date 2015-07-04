package cl.madal.skorpion.servicio;

import cl.madal.skorpion.modelo.Region;
import java.util.List;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
public interface ServicioGeografico {

    public Region consultarRegion(Integer id);

    public Region consultarRegion(String nombre);
    
    public Region consultarRegionPorNumero(Integer numero);
    
    public List<Region> consultarRegiones();
    
    public Region guardar(Region region);
    
    public boolean eliminar(Region region);
}
