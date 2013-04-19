/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Usuario;

/**
 *
 * @author lesly
 */
@Stateless
public class UsuarioDao extends AbstractDao<Usuario> implements UsuarioDaoLocal {
    @PersistenceContext(unitName = "MyRide-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioDao() {
        super(Usuario.class);
    }
    
}
