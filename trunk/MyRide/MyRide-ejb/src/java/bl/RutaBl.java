/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import daos.RutaDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelos.Ruta;

/**
 *
 * @author lesly
 */
@Stateless
public class RutaBl implements RutaBlLocal {
    @EJB
    private RutaDaoLocal rutaDao;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrar(Ruta ruta) {
        rutaDao.create(ruta);
    }

    @Override
    public void modificar(Ruta ruta) {
        rutaDao.edit(ruta);
    }

    @Override
    public void eliminar(Ruta ruta) {
        rutaDao.remove(ruta);
    }

    @Override
    public List<Ruta> obtenerRuta() {
        return rutaDao.findAll();
    }

    @Override
    public Ruta getRutaPorId(int idRuta) {
        return rutaDao.find(idRuta);
    }

     

}
