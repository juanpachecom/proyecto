package cl.madal.skorpion.servicio;

import cl.madal.skorpion.modelo.Provincia;
import cl.madal.skorpion.modelo.Region;
import java.util.List;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
public interface ServicioGeografico {

    /*
     * Regiones
     */
    public Region consultarRegion(Integer id);

    public Region consultarRegion(String nombre);

    public Region consultarRegionPorNumero(Integer numero);

    public List<Region> consultarRegiones();

    public Region guardar(Region region);

    public boolean eliminar(Region region);

    /*
     * Provincias
     */
    public Provincia consultarProvincia(Integer id);

    public Provincia consultarProvincia(String nombre, Region region);

    public List<Provincia> consultarProvincias(Region region);

    public List<Provincia> consultarProvincias();

    public Provincia guardar(Provincia provincia);

    public boolean eliminar(Provincia provincia);
}
