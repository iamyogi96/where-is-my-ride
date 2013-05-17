/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import daos.PuntosDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelos.Puntos;
import modelos.Ruta;

/**
 *
 * @author lesly
 */
@Stateless
public class PuntosBl implements PuntosBlLocal {
    @EJB
    private PuntosDaoLocal puntosDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrar(Puntos puntos) {
        puntosDao.create(puntos);
    }

    @Override
    public void modificar(Puntos puntos) {
        puntosDao.edit(puntos);
    }

    @Override
    public void eliminar(Puntos puntos) {
        puntosDao.remove(puntos);
    }

    @Override
    public List<Puntos> obtenerPuntos() {
        return puntosDao.findAll();
    }
    
    @Override
     public Puntos findById(int idPunto) {
          return puntosDao.find(idPunto);
    }

    @Override
    public List<Puntos> obtenerPuntosPorRuta(Ruta ruta) {
        return puntosDao.findByRuta(ruta);
    }
    
    

}