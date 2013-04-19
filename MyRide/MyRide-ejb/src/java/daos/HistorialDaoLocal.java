/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Local;
import modelos.Historial;

/**
 *
 * @author lesly
 */
@Local
public interface HistorialDaoLocal {

    void create(Historial historial);

    void edit(Historial historial);

    void remove(Historial historial);

    Historial find(Object id);

    List<Historial> findAll();

    List<Historial> findRange(int[] range);

    int count();
    
}
