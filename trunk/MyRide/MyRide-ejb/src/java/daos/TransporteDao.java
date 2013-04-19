/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Transporte;

/**
 *
 * @author lesly
 */
@Stateless
public class TransporteDao extends AbstractDao<Transporte> implements TransporteDaoLocal {
    @PersistenceContext(unitName = "MyRide-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransporteDao() {
        super(Transporte.class);
    }
    
}
