/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.UsuariosBlLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelos.Usuario;

/**
 *
 * @author Yessy
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    @EJB
    private UsuariosBlLocal usuariosBl;

    /**
     * Creates a new instance of UsuarioBean
     */
     //variables locales
    private List<Usuario> lista;
    private Usuario usuario;
     private String accion;
    
    public UsuarioBean() {
         usuario=new Usuario(); 
    }
    //get y set

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        lista=usuariosBl.obtenerUsuarios();
         
        return lista;
    }

   
    //acciones
    public String procesarAccion() {
         //usuariosBl.registrar(usuario);
        if(accion.equalsIgnoreCase("Nuevo")){
            usuariosBl.registrar(usuario);
        
                }else{
        if(accion.equalsIgnoreCase("Editar")){
        usuariosBl.modificar(usuario);
        }
        else{
        if(accion.equalsIgnoreCase("Eliminar"))
            usuariosBl.eliminar(usuario);
           
        }
        }
        
        return "UsuarioLista";
    }

    //Listeners
    //Listeners
    public void prepararNuevoRegistro(ActionEvent evt) {
        accion="Nuevo";
        usuario = new Usuario();
    }
   public void prepararEditar(ActionEvent evt) {
       accion="Editar";
      System.out.println(evt.getComponent().getClientId());        
        int index=Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        usuario=lista.get(index);
    } 
   public void prepararEliminar(ActionEvent evt){
   accion="Eliminar";
   System.out.println(evt.getComponent().getClientId());
    int index=Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        usuario=lista.get(index);
   
   }
}
