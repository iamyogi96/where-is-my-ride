import bl.RutaBlLocal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelos.Ruta;
/**
 *
 * @author Lenovo-user
 */
@ManagedBean
@SessionScoped
public class RutaBean {
    @EJB
    private RutaBlLocal rutaBl;
    private Ruta ruta;
    private List<Ruta> listaRuta;
    private String accion = "";
    public RutaBean() {
        ruta = new Ruta();
    }
    public Ruta getRuta() {
        return ruta;
    }
    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    public List<Ruta> getListaRuta() {
        return listaRuta;
    }
    public void setListaRuta(List<Ruta> listaRuta) {
        this.listaRuta = listaRuta;
    }
    public String procesarAccion() {
        //rutasBl.registrar(ruta);
        if (accion.equalsIgnoreCase("Nuevo")) {
            rutaBl.registrar(ruta);

        } else {
            if (accion.equalsIgnoreCase("Editar")) {
                rutaBl.modificar(ruta);
            } else {
                if (accion.equalsIgnoreCase("Eliminar")) {
                    rutaBl.eliminar(ruta);
                }

            }
        }
        return "RutasLista";
    }
    public String procesarRegresar() {
        if (accion.equalsIgnoreCase("Nuevo") || accion.equalsIgnoreCase("Editar")) {
            return "RutaCrearEditar";
        } else {
            return "RutasLista";
        }
    }
    //Listeners
    //Listeners
    public void ImagenBloob(ActionEvent evt) throws FileNotFoundException {
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/databaseName", "root", "root");
//        FileInputStream fis = null;
//        PreparedStatement ps = null;
//    File file = new File("loogo.jpg");
//    FileInputStream s=new FileInputStream(file);
//     byte b[]=new byte[256];
//    for(int x=0;x<256;x++){
//            try {
//                b[x]=(byte) s.read();
//            } catch (IOException ex) {
//                Logger.getLogger(RutaBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
    
    }

    public void prepararNuevoRegistro(ActionEvent evt) {
        accion = "Nuevo";
        ruta = new Ruta();
    }

    public void prepararEditar(ActionEvent evt) {
        accion = "Editar";
        System.out.println(evt.getComponent().getClientId());
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        ruta = listaRuta.get(index);
    }

    public void prepararEliminar(ActionEvent evt) {
        accion = "Eliminar";
        System.out.println(evt.getComponent().getClientId());
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        ruta = listaRuta.get(index);

    }
    /**
     * Creates a new instance of RutaBean
     */
}
