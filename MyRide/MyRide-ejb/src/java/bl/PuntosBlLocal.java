/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.List;
import javax.ejb.Local;
import modelos.Puntos;

/**
 *
 * @author lesly
 */
@Local
public interface PuntosBlLocal {

    void registrar(Puntos puntos);

    void modificar(Puntos puntos);

    void eliminar(Puntos puntos);

    List<Puntos> obtenerPuntos();
     Puntos findById(int idPunto);
}
