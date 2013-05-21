
import bl.PuntosBlLocal;
import bl.RutaBlLocal;
import bl.TransporteBlLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelos.Puntos;
import modelos.Ruta;
import modelos.Transporte;
import org.primefaces.event.map.OverlaySelectEvent;
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
public class RutasMobilBean implements Serializable{

    @EJB
    private TransporteBlLocal transporteBl;
    @EJB
    private PuntosBlLocal puntosBl;
    @EJB
    private RutaBlLocal rutaBl;
    /////////////////////////////
    private List<Ruta> listaRuta;
    private List<Marker> camiones;
    private MapModel drawRuta;
    //public MapModel simpleModel;
    private Ruta ruta;
    private String centro = "-103.190587,20.293794";
    //    private double lat = 41.381542;
//    private double lon = 2.122893;
    private MapModel advancedModel;
    private Marker marker;
    private Transporte transporteInfo;

////////////get and set/////////////////////
    public MapModel getAdvancedModel() {
        return advancedModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        System.out.println("ngjgjfjjffjfjgfdgfdgdg");
        marker = (Marker) event.getOverlay();
    }

    public Marker getMarker() {
        return marker;
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

///////////////////////metodos///////////
    public RutasMobilBean() {
        //  simpleModel = new DefaultMapModel();  
        //Shared coordinates  
//        LatLng coord1 = new LatLng(lat, lon);
        //Basic marker  
//        simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));  
        advancedModel= new DefaultMapModel();
//      
        drawRuta = new DefaultMapModel();
        
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
                camiones.add(new Marker(new LatLng(p.getLongitud(), p.getLatitud()), "Algo"));
            }
            centro = lineas.getPaths().get(0).getLat() + "," + lineas.getPaths().get(0).getLng();
            System.out.println(centro);
            lineas.setStrokeColor("#FF9900");
            lineas.setStrokeWeight(5);

            drawRuta.addOverlay(lineas);
            for (Marker m : camiones) {
                drawRuta.addOverlay(m);
            }
        }
    }

    public void actualizarCamion() {
        List<Marker> nuevo = new ArrayList<Marker>();
        Random r = new Random();
        r.nextDouble();
//        for (Marker m : drawRuta.getMarkers()) {
        for (int x = 0; x < camiones.size(); x++) {
            if (r.equals(camiones.get(x).getLatlng().getLat())) {
                System.out.println("Entro al random");
                if (camiones.get(x).getLatlng().getLat() > camiones.get(x + 1).getLatlng().getLat()) {
                    System.out.println("Entro a agregar la ruta y la marca");
                    nuevo.add(new Marker(new LatLng(camiones.get(x).getLatlng().getLat() + 0.001, camiones.get(x).getLatlng().getLng() + 0.001)));
                    advancedModel.addOverlay(new Marker(new LatLng(camiones.get(x).getLatlng().getLat() + 0.001, camiones.get(x).getLatlng().getLng() + 0.001), "Yuri + algo jeje", "loogo.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
                }
            } else {
                System.out.println("No entro al ramdom");
            }
        }
        drawRuta.getMarkers().clear();
        for (Marker m : nuevo) {
            drawRuta.addOverlay(m);
        }
    }

    public void infoCamion() {
//        transporteInfo.getNumEconomico();
//        transporteInfo.getDisponible();
    }
}
