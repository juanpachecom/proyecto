package cl.madal.skorpion.ws.webservice.impl;

import cl.madal.skorpion.modelo.Comuna;
import cl.madal.skorpion.modelo.Region;
import cl.madal.skorpion.servicio.ServicioGeografico;
import cl.madal.skorpion.ws.webservice.Servicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
@WebService(endpointInterface = "cl.madal.skorpion.ws.webservice.Servicio")
public class ServicioImpl implements Servicio, Serializable {

    @Resource(name = "servicioGeografico")
    private ServicioGeografico servicioGeografico;
    private final static Logger logger = LoggerFactory.getLogger(ServicioImpl.class);

    @Override
    public List<String> comunasPorNumeroRegion(Integer numero) {
        List<String> nombresComunas = new ArrayList<String>();
        try {
            if (numero != null) {
                Region region = servicioGeografico.consultarRegionPorNumero(numero);
                List<Comuna> comunas = servicioGeografico.consultarComunas(region);
                for (Comuna comuna : comunas) {
                    nombresComunas.add(comuna.getNombre());
                }
            }
        } catch (Exception e) {
            nombresComunas = new ArrayList<String>();
            logger.error("Error al obtener nombre de comunas: {}", e.toString());
            logger.debug("Error al obtener nombre de comunas: {}", e.toString(), e);
        }
        return nombresComunas;
    }

}
