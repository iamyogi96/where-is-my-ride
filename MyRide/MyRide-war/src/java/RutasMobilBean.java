/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.PuntosBlLocal;
import bl.RutaBlLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelos.Puntos;
import modelos.Ruta;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
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
    private List<Marker> camiones;
    private MapModel drawRuta;
    //public MapModel simpleModel;
    private Ruta ruta;
    private String centro = "41.381542, 2.122893";
    private double lat=41.381542;
    private double lon=2.122893;
    /**
     * Creates a new instance of RutasMobilBean
     */
    public RutasMobilBean() {
      //  simpleModel = new DefaultMapModel();  
          
        //Shared coordinates  
        LatLng coord1 = new LatLng(lat, lon);  
        
        //Basic marker  
//        simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));  
        
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
        List<Puntos> puntos = puntosBl.obtenerPuntosPorRuta(ruta);
        drawRuta = new DefaultMapModel();
        camiones = new ArrayList<Marker>();
        if (!puntos.isEmpty()) {
            Polyline lineas = new Polyline();
            for (Puntos p : puntos) {
                lineas.getPaths().add(new LatLng(p.getLongitud(), p.getLatitud()));
                camiones.add(new Marker(new LatLng(p.getLongitud(),p.getLatitud()),"Algo"));
            }
            centro = lineas.getPaths().get(0).getLat() + "," + lineas.getPaths().get(0).getLng();
            System.out.println(centro);
            lineas.setStrokeColor("#FF9900");
            lineas.setStrokeWeight(5);
            
            drawRuta.addOverlay(lineas);
            for( Marker m: camiones){
                drawRuta.addOverlay(m);
            }
        }
    }    
        
    public void actualizarCamion(){
        List<Marker> nuevo= new ArrayList<Marker>();
//        
        for(Marker m : drawRuta.getMarkers()){
//            for(int x=0; x< camiones.size();x++){
            //if(m.getLatlng().getLat()>m.getLatlng().getLat()+1)
              
            {
                nuevo.add(new Marker(new LatLng(m.getLatlng().getLat()+0.001, m.getLatlng().getLng()+0.001)));
            }
        }
        drawRuta.getMarkers().clear();
        for( Marker m: nuevo){
                drawRuta.addOverlay(m);
            }
    ////
       
    
    }
    

 
    
}
