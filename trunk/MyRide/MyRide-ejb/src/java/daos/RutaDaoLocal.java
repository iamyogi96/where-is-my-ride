/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Local;
import modelos.Ruta;

/**
 *
 * @author lesly
 */
@Local
public interface RutaDaoLocal {

    void create(Ruta ruta);

    void edit(Ruta ruta);

    void remove(Ruta ruta);

    Ruta find(Object id);

    List<Ruta> findAll();

    List<Ruta> findRange(int[] range);

    int count();

    Ruta getRutaPorId(Ruta idRutaG);
    
}
