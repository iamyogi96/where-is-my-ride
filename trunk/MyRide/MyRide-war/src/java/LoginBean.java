/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author lesly
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String user="";
    private String pass="";
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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
    
    public String acceso(){
    if(user.equals("admin") && pass.equals("111")){
    return "MenuAdministrador";
    }
     if(user.equals("user") && pass.equals("000")){
    return "ListaUsuarios";
    }
    else{
    return "PaginaPrincipal";
    }
    }
}
