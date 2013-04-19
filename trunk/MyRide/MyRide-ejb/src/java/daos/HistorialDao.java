/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Historial;

/**
 *
 * @author lesly
 */
@Stateless
public class HistorialDao extends AbstractDao<Historial> implements HistorialDaoLocal {
    @PersistenceContext(unitName = "MyRide-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialDao() {
        super(Historial.class);
    }
    
}
