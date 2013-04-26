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
import javax.faces.event.ActionEvent;
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
    private String accion;

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
    public String processarAccion(){
    if(accion.equalsIgnoreCase("Nuevo")){
    puntosBl.registrar(puntos);
    }else{
    if(accion.equalsIgnoreCase("Editar")){
    puntosBl.modificar(puntos);
    }else{
    if(accion.equalsIgnoreCase("Eliminar")){
    puntosBl.eliminar(puntos);
    }
    }
    }
    accion=" ";
    return "PuntosLista";
    }
    
    public void prepararNuevo(){
    accion="Nuevo";
    puntos=new Puntos();
    }
    
    public void prepararEditar(ActionEvent evnt){
    accion="Editar";
    int index=Integer.parseInt(evnt.getComponent().getClientId().split(":")[2]);
    puntos=listaPunto.get(index);
    }
    
    public void prepararEliminar(ActionEvent evnt){
    accion="Eliminar";
    int index=Integer.parseInt(evnt.getComponent().getClientId().split(":")[2]);
    puntos=listaPunto.get(index);
    }

    
//    public String crear(){
//    puntosBl.registrar(puntos);
//    return "ListaPuntos";
//    }
    
    
}