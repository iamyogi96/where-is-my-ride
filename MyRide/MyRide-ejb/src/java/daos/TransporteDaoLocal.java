/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Local;
import modelos.Transporte;

/**
 *
 * @author lesly
 */
@Local
public interface TransporteDaoLocal {

    void create(Transporte transporte);

    void edit(Transporte transporte);

    void remove(Transporte transporte);

    Transporte find(Object id);

    List<Transporte> findAll();

    List<Transporte> findRange(int[] range);

    int count();
    
}
