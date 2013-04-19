/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Puntos;

/**
 *
 * @author lesly
 */
@Stateless
public class PuntosDao extends AbstractDao<Puntos> implements PuntosDaoLocal {
    @PersistenceContext(unitName = "MyRide-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuntosDao() {
        super(Puntos.class);
    }
    
}
