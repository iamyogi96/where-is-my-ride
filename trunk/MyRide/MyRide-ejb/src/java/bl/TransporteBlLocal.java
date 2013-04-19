/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.List;
import javax.ejb.Local;
import modelos.Transporte;

/**
 *
 * @author lesly
 */
@Local
public interface TransporteBlLocal {

    void registrar(Transporte transposte);

    void modificar(Transporte transporte);

    void eliminar(Transporte transporte);

    List<Transporte> obtenerTransporte();
    
}