/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import daos.HistorialDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelos.Historial;

/**
 *
 * @author lesly
 */
@Stateless
public class HistorialBl implements HistorialBlLocal {
    @EJB
    private HistorialDaoLocal historialDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrar(Historial historial) {
        historialDao.create(historial);
    }

    @Override
    public List<Historial> obtenerHistorial() {
        return null;
    }

}
