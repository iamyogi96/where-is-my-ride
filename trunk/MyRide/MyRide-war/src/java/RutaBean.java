
import bl.RutaBlLocal;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.imageio.ImageIO;
import modelos.Ruta;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Lenovo-user
 */
@ManagedBean
@SessionScoped
public class RutaBean implements Serializable {

    @EJB
    private RutaBlLocal rutaBl;
    private Ruta ruta;
    private List<Ruta> listaRuta;
    private String accion = "";
    private UploadedFile file; //Vatiable para almacenar el archivo
    private StreamedContent img;

    public RutaBean() {
        ruta = new Ruta();
    }

    public Ruta getRuta() {
        return ruta;
    }
    //------------get y set para el archivo-------------------------

    public StreamedContent getImg() {
        if(ruta.getLogotipo()!=null){
            img= new DefaultStreamedContent(new ByteArrayInputStream(ruta.getLogotipo()));
        }
        return img;
    }


    
    //---------------------------------------------------------------

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

//****************************************************************************
//----------------------------Metodo para subir un archivo--------------------
    //****************************************************************************
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg;
        try {
            ruta.setLogotipo(event.getFile().getContents());
            //img=new DefaultStreamedContent(event.getFile().getInputstream());
            msg = new FacesMessage("Correcto", event.getFile().getFileName() + " ha sido cargado");
        } catch (Exception e) {
            msg = new FacesMessage("Error", event.getFile().getFileName() + " no se subio");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);


    }

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
