/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.List;
import javax.ejb.Local;
import modelos.Ruta;

/**
 *
 * @author lesly
 */
@Local
public interface RutaBlLocal {

    void registrar(Ruta ruta);

    void modificar(Ruta ruta);

    void eliminar(Ruta ruta);

    List<Ruta> obtenerRuta();
    
    public Ruta getRutaPorId(int idRuta);
    
}
