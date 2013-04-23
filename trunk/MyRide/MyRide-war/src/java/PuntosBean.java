/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.PuntosBlLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelos.Puntos;

/**
 *
 * @author lesly
 */
@ManagedBean
@SessionScoped
public class PuntosBean {
    @EJB
    private PuntosBlLocal puntosBl;
    private List<Puntos> listaPunto;
    private Puntos puntos;

    public Puntos getPuntos() {
        return puntos;
    }

    public void setPuntos(Puntos puntos) {
        this.puntos = puntos;
    }

    public List<Puntos> getListaPunto() {
        return listaPunto;
    }

    public void setListaPunto(List<Puntos> listaPunto) {
        this.listaPunto = listaPunto;
    }
    
            
    /**
     * Creates a new instance of PuntosBean
     */
    public PuntosBean() {
    }
    public String crear(){
    puntosBl.registrar(puntos);
    return "ListaPuntos";
    }
    
    
}
