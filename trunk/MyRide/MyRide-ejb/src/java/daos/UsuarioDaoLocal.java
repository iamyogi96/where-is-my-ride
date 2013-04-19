/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Local;
import modelos.Usuario;

/**
 *
 * @author lesly
 */
@Local
public interface UsuarioDaoLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
}
