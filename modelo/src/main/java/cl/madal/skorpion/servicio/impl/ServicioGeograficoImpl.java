package cl.madal.skorpion.servicio.impl;

import cl.madal.skorpion.modelo.Comuna;
import cl.madal.skorpion.modelo.Provincia;
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

    /*
     * Regiones
     */
    @Override
    public Region consultarRegion(Long id) {
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

    /*
     * provincias
     */
    @Override
    public Provincia consultarProvincia(Long id) {
        Provincia provincia = null;
        try {
            if (id != null) {
                provincia = provinciaRepository.findOne(id);
            }
        } catch (Exception e) {
            provincia = null;
            logger.error("Error al consultar Provincia: {}", e.toString());
            logger.debug("Error al consultar Provincia: {}", e.toString(), e);
        }
        return provincia;
    }

    @Override
    public Provincia consultarProvincia(String nombre, Region region) {
        Provincia provincia = null;
        try {
            if (StringUtils.isNotBlank(nombre) && region != null) {
                provincia = provinciaRepository.findByNombreIgnoreCaseAndRegion(nombre, region);
            }

        } catch (Exception e) {
            provincia = null;
            logger.error("Error al consultar Provincia: {}", e.toString());
            logger.debug("Error al consultar Provincia: {}", e.toString(), e);
        }
        return provincia;
    }

    @Override
    public List<Provincia> consultarProvincias() {
        List<Provincia> provincia = new ArrayList<Provincia>();
        try {
            provincia = provinciaRepository.findAll();
        } catch (Exception e) {
            provincia = new ArrayList<Provincia>();
            logger.error("Error al consultar Provincias: {}", e.toString());
            logger.debug("Error al consultar Provincias: {}", e.toString(), e);
        }
        return provincia;
    }

    @Override
    @Transactional
    public Provincia guardar(Provincia provincia) {
        Provincia resultado = null;
        try {
            if (provincia != null) {
                resultado = provinciaRepository.save(provincia);
            }
        } catch (Exception e) {
            resultado = null;
            logger.error("Error al guardar provincia: {}", e.toString());
            logger.debug("Error al guardar provincia: {}", e.toString(), e);
        }
        return resultado;
    }

    @Override
    @Transactional
    public boolean eliminar(Provincia provincia) {
        boolean ok = false;
        try {
            if (provincia != null) {
                provinciaRepository.delete(provincia);
                ok = true;
            }
        } catch (Exception e) {
            ok = false;
            logger.error("Error al eliminar provincia: {}", e.toString());
            logger.debug("Error al eliminar provincia: {}", e.toString(), e);
        }
        return ok;
    }

    /*
     * comunas
     */
    @Override
    public Comuna consultarComuna(Long id) {
        Comuna comuna = null;
        try {
            if (id != null) {
                comuna = comunaRepository.findOne(id);
            }
        } catch (Exception e) {
            comuna = null;
            logger.error("Error al consultar comuna: {}", e.toString());
            logger.debug("Error al consultar comuna: {}", e.toString(), e);
        }
        return comuna;
    }

    @Override
    public Comuna consultarComuna(String nombre, Provincia provincia) {
        Comuna comuna = null;
        try {
            if (StringUtils.isNotBlank(nombre) && provincia != null) {
                comuna = comunaRepository.findByNombreIgnoreCaseAndProvincia(nombre, provincia);
            }
        } catch (Exception e) {
            comuna = null;
            logger.error("Error al consultar Comuna: {}", e.toString());
            logger.debug("Error al consultar Comuna: {}", e.toString(), e);
        }
        return comuna;
    }

    @Override
    public List<Comuna> consultarComunas() {
        List<Comuna> comunas = new ArrayList<Comuna>();
        try {
            comunas = comunaRepository.findAll();
        } catch (Exception e) {
            comunas = new ArrayList<Comuna>();
            logger.error("Error al consultar Provincias: {}", e.toString());
            logger.debug("Error al consultar Provincias: {}", e.toString(), e);
        }
        return comunas;
    }

    @Override
    public List<Comuna> consultarComunas(Region region) {
        List<Comuna> comunas = new ArrayList<Comuna>();
        try {
            if (region != null) {
                comunas = comunaRepository.findByProvinciaRegion(region);
            }
        } catch (Exception e) {
            comunas = new ArrayList<Comuna>();
            logger.error("Error al consultar Provincias: {}", e.toString());
            logger.debug("Error al consultar Provincias: {}", e.toString(), e);
        }
        return comunas;
    }

    @Override
    @Transactional
    public Comuna guardar(Comuna comuna) {
        Comuna resultado = null;
        try {
            if (comuna != null) {
                resultado = comunaRepository.save(comuna);
            }
        } catch (Exception e) {
            resultado = null;
            logger.error("Error al guardar comuna: {}", e.toString());
            logger.debug("Error al guardar comuna: {}", e.toString(), e);
        }
        return resultado;

    }

    @Override
    @Transactional
    public boolean eliminar(Comuna comuna) {
        boolean ok = false;
        try {
            if (comuna != null) {
                comunaRepository.delete(comuna);
                ok = true;
            }
        } catch (Exception e) {
            ok = false;
            logger.error("Error al eliminar comuna: {}", e.toString());
            logger.debug("Error al eliminar comuna: {}", e.toString(), e);
        }
        return ok;
    }

}
