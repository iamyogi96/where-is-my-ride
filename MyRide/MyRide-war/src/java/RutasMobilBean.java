/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.PuntosBlLocal;
import bl.RutaBlLocal;
import java.awt.Color;
import java.util.List;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelos.Puntos;
import modelos.Ruta;
import modelos.Ruta;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polyline;

/**
 *
 * @author snake_gt
 */
@ManagedBean
@SessionScoped
public class RutasMobilBean {

    @EJB
    private PuntosBlLocal puntosBl;
    @EJB
    private RutaBlLocal rutaBl;
    private List<Ruta> listaRuta;
    private MapModel drawRuta;
    private Ruta ruta;
    private String centro = "41.381542, 2.122893";

    /**
     * Creates a new instance of RutasMobilBean
     */
    public RutasMobilBean() {
    }

    public List<Ruta> getListaRuta() {
        listaRuta = rutaBl.obtenerRuta();
        return listaRuta;
    }

    public MapModel getDrawRuta() {
        return drawRuta;
    }

    public String getCentro() {
        return centro;
    }

    public void seleccionarRuta(ActionEvent evt) {
        ruta = listaRuta.get(Integer.parseInt(evt.getComponent().getClientId().split(":")[2]));
        List<Puntos> puntos = puntosBl.obtenerPuntos();
        if (!puntos.isEmpty()) {
            Polyline lineas = new Polyline();
            for (Puntos p : puntos) {
                lineas.getPaths().add(new LatLng(p.getLatitud(), p.getLongitud()));
            }
            centro = lineas.getPaths().get(0).getLat() + "," + lineas.getPaths().get(0).getLng();
            System.out.println(centro);
            lineas.setStrokeColor("#FF9900");
            lineas.setStrokeWeight(5);
            drawRuta = new DefaultMapModel();
            drawRuta.addOverlay(lineas);
        }
    }
}
