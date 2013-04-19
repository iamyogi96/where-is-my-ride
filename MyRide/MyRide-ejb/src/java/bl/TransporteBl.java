/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import daos.TransporteDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelos.Transporte;

/**
 *
 * @author lesly
 */
@Stateless
public class TransporteBl implements TransporteBlLocal {
    @EJB
    private TransporteDaoLocal transporteDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrar(Transporte transposte) {
        transporteDao.create(transposte);
    }

    @Override
    public void modificar(Transporte transporte) {
        transporteDao.edit(transporte);
    }

    @Override
    public void eliminar(Transporte transporte) {
        transporteDao.remove(transporte);
    }

    @Override
    public List<Transporte> obtenerTransporte() {
        return transporteDao.findAll();
    }

}
