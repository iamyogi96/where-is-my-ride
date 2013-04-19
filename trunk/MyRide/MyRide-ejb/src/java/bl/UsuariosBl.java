/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import daos.UsuarioDaoLocal;
import enumeraciones.EstadoTransaccion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelos.Usuario;

/**
 *
 * @author lesly
 */
@Stateless
public class UsuariosBl implements UsuariosBlLocal {
    @EJB
    private UsuarioDaoLocal usuarioDao;
    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrar(Usuario usuario) {
        usuarioDao.create(usuario);
        
    }

    @Override
    public void modificar(Usuario usuario) {
       usuarioDao.edit(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
       usuarioDao.remove(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioDao.findAll();
    }
}
