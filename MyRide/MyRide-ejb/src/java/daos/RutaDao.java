/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Ruta;

/**
 *
 * @author lesly
 */
@Stateless
public class RutaDao extends AbstractDao<Ruta> implements RutaDaoLocal {
    @PersistenceContext(unitName = "MyRide-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutaDao() {
        super(Ruta.class);
    }
    
}
