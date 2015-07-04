package cl.madal.skorpion.servicio.impl;

import cl.madal.skorpion.modelo.Region;
import cl.madal.skorpion.repository.ComunaRepository;
import cl.madal.skorpion.repository.ProvinciaRepository;
import cl.madal.skorpion.repository.RegionRepository;
import cl.madal.skorpion.servicio.ServicioGeografico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
@Service("servicioGeografico")
public class ServicioGeograficoImpl implements ServicioGeografico, Serializable {

    @Resource(name = "regionRepository")
    private RegionRepository regionRepository;
    @Resource(name = "provinciaRepository")
    private ProvinciaRepository provinciaRepository;
    @Resource(name = "comunaRepository")
    private ComunaRepository comunaRepository;
    public final static Logger logger = LoggerFactory.getLogger(ServicioGeograficoImpl.class);

    @Override
    public Region consultarRegion(Integer id) {
        Region region = null;
        try {
            if (id != null) {
                region = regionRepository.findOne(id);
            }
        } catch (Exception e) {
            region = null;
            logger.error("Error al consultar Region: {}", e.toString());
            logger.debug("Error al consultar Region: {}", e.toString(), e);
        }
        return region;
    }

    @Override
    public Region consultarRegion(String nombre) {
        Region region = null;
        try {
            if (StringUtils.isNotBlank(nombre)) {
                region = regionRepository.findByNombreIgnoreCase(nombre);
            }
        } catch (Exception e) {
            region = null;
            logger.error("Error al consultar Region: {}", e.toString());
            logger.debug("Error al consultar Region: {}", e.toString(), e);
        }
        return region;
    }

    @Override
    public Region consultarRegionPorNumero(Integer numero) {

        Region region = null;
        try {
            if (numero != null) {
                region = regionRepository.findByNumero(numero);
            }
        } catch (Exception e) {
            region = null;
            logger.error("Error al consultar Region: {}", e.toString());
            logger.debug("Error al consultar Region: {}", e.toString(), e);
        }
        return region;

    }

    @Override
    public List<Region> consultarRegiones() {
        List<Region> regiones = new ArrayList<Region>();
        try {
            regiones = regionRepository.findAll();
        } catch (Exception e) {
            regiones = new ArrayList<Region>();
            logger.error("Error al consultar regiones: {}", e.toString());
            logger.debug("Error al consultar regiones: {}", e.toString(), e);
        }
        return regiones;
    }

    @Override
    @Transactional
    public Region guardar(Region region) {
        Region resultado = null;
        try {
            if (region != null) {
                resultado = regionRepository.save(region);
            }
        } catch (Exception e) {
            resultado = null;
            logger.error("Error al guardar region: {}", e.toString());
            logger.debug("Error al guardar region: {}", e.toString(), e);
        }
        return resultado;
    }

    @Override
    @Transactional
    public boolean eliminar(Region region) {
        boolean ok = false;
        try {
            if (region != null) {
                regionRepository.delete(region);
                ok = true;
            }
        } catch (Exception e) {
            ok = false;
            logger.error("Error al eliminar region: {}", e.toString());
            logger.debug("Error al eliminar region: {}", e.toString(), e);
        }
        return ok;
    }
}
