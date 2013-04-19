/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Local;
import modelos.Puntos;

/**
 *
 * @author lesly
 */
@Local
public interface PuntosDaoLocal {

    void create(Puntos puntos);

    void edit(Puntos puntos);

    void remove(Puntos puntos);

    Puntos find(Object id);

    List<Puntos> findAll();

    List<Puntos> findRange(int[] range);

    int count();
    
}
