/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.PuntosBlLocal;
import bl.RutaBlLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelos.Puntos;
import modelos.Ruta;

/**
 *
 * @author lesly
 */
@ManagedBean
@SessionScoped
public class PuntosBean {
    @EJB
    private RutaBlLocal rutaBl;
    @EJB
    private PuntosBlLocal puntosBl;
    
    private List<Puntos> listaPunto;
    private List<Ruta> listaRuta;
    private Puntos puntos;

    public Puntos getPuntos() {
        return puntos;
    }

    public void setPuntos(Puntos puntos) {
        this.puntos = puntos;
    }

    public List<Puntos> getListaPunto() {
        listaPunto=puntosBl.obtenerPuntos();
        return listaPunto;
    }
    
    public List<Ruta> getListaRuta(){
    listaRuta=rutaBl.obtenerRuta();
    return listaRuta;
    }
            
    /**
     * Creates a new instance of PuntosBean
     */
    public PuntosBean() {
        puntos=new Puntos();
    }
    
    
    public String crear(){
    puntosBl.registrar(puntos);
    return "ListaPuntos";
    }
    
    
}
