/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bl.UsuariosBlLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.swing.JOptionPane;
import modelos.Usuario;

/**
 *
 * @author lesly
 */
@ManagedBean
@SessionScoped

public class LoginBean implements Serializable{
    @EJB
    private UsuariosBlLocal usuariosBl;

    private String user;
    private String pass;
    private Usuario usuario;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void savePerson(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + user +  "!"));  
    } 
    
    public void acceso(ActionEvent evt){
        System.out.println("drcfvgbhjnkm,l");
        String page="";
     for(Usuario usu:usuariosBl.obtenerUsuarios()){
    if(user.equals(usu.getNombre()) && pass.equals(usu.getContrasena())){
    page= "MenuAdministrador";
    }
    else{
    page= "Error";
    }
     }
    }
    
//    public String entrar(){
//    if(user.equals(usuario.getNombre()) && pass.equals(usuario.getContrasena())){
//    return "MenuAdministrador";
//    }else{
//    return "PaginaPrincipal";
//    }
//    }
    
  
}
