/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.TransporteBlLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
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
    private TransporteBlLocal transporteBl;
    private Transporte transporte;
    private String accion;
    private List<Transporte> lista;
    //-------------------Constructor-------

    public TransportesBean() {
        transporte = new Transporte();
    }
    //-------------------metodos GET y SET-------

    public List<Transporte> getLista() {
        lista = transporteBl.obtenerTransporte();
        return lista;
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

    //-------------------Listener-------
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
