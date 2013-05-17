/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelos.Puntos;
import modelos.Ruta;

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

    @Override
    public List<Puntos> findByRuta(Ruta ruta) {
        Query q= em.createNamedQuery("Puntos.findByRuta");
        q.setParameter("idRuta", ruta.getId());
        return q.getResultList();
    }

    
    
}
