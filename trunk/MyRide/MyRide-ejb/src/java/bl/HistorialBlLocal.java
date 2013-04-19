/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.List;
import javax.ejb.Local;
import modelos.Historial;

/**
 *
 * @author lesly
 */
@Local
public interface HistorialBlLocal {

    void registrar(Historial historial);

    List<Historial> obtenerHistorial();
    
}
