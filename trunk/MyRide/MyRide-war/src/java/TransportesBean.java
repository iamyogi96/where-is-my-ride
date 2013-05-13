/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.RutaBlLocal;
import bl.TransporteBlLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelos.Ruta;
import modelos.Transporte;

/**
 *
 * @author Santiago
 */
@ManagedBean
@SessionScoped
public class TransportesBean {

    //-------------------Variables(propiedades)-------
    @EJB
    private RutaBlLocal rutaBl;
    @EJB
    private TransporteBlLocal transporteBl;
    
    private Transporte transporte;
    private String accion;
    private List<Transporte> lista;
    private List<Ruta> listaRuta;
    private int idRutaSeleccionada;
    //-------------------Constructor-------

    public TransportesBean() {
        transporte = new Transporte();
    }
    //-------------------metodos GET y SET-------

    public List<Transporte> getLista() {
        lista = transporteBl.obtenerTransporte();
        return lista;
    }

    public List<Ruta> getListaRuta() {
        listaRuta = rutaBl.obtenerRuta();
        return listaRuta;
    }

    public int getIdRutaSeleccionada() {
        return idRutaSeleccionada;
    }

    public void setIdRutaSeleccionada(int idRutaSeleccionada) {
        this.idRutaSeleccionada = idRutaSeleccionada;
    }
    
    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    //-------------------Acciones-------
    public String procesarAccion() {
        System.out.println("accion autor>>>>" + accion);
        if (accion.equalsIgnoreCase("Nuevo")) {
            transporteBl.registrar(transporte);
        } else if (accion.equalsIgnoreCase("Editar")) {
            transporteBl.modificar(transporte);
        } else if (accion.equalsIgnoreCase("Eliminar")) {
            transporteBl.eliminar(transporte);
        }
        accion = "";
        return "TransportesLista";
    }
    public String procesarSeleccion(){
        transporte.setRutaid(rutaBl.getRutaPorId(idRutaSeleccionada));
        return "TransportesConfirmar";
    }
    //-------------------Listener-------
    public String prepararRuta() {
        transporte.setRutaid(rutaBl.getRutaPorId(idRutaSeleccionada));
        return "TransportesConfirmar";
    }
    
    public void prepararNuevo(ActionEvent evt) {
        transporte = new Transporte();
        accion = "Nuevo";
    }

    public void prepararEditar(ActionEvent evt) {
        System.out.println(evt.getComponent().getClientId());
        String[] arreglo = evt.getComponent().getClientId().split(":");
        String num = arreglo[2];
        int index = Integer.parseInt(num);
        transporte = lista.get(index);
        accion = "Editar";
        // int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
    }

    public void prepararEliminar(ActionEvent evt) {
        System.out.println(evt.getComponent().getClientId());
        String[] arreglo = evt.getComponent().getClientId().split(":");
        String num = arreglo[2];
        int index = Integer.parseInt(num);
        transporte = lista.get(index);
        accion = "Eliminar";
    }
}
