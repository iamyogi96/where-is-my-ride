/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.List;
import javax.ejb.Local;
import modelos.Usuario;

/**
 *
 * @author lesly
 */
@Local
public interface UsuariosBlLocal {

    void registrar(Usuario usuario);

    void modificar(Usuario usuario);

    void eliminar(Usuario usuario);

    List<Usuario> obtenerUsuarios();
    
}