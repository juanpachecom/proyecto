package cl.madal.skorpion.ws.webservice;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
@WebService
public interface Servicio {

    public List<String> comunasPorNumeroRegion(@WebParam(name = "numero") Integer numero);
}
