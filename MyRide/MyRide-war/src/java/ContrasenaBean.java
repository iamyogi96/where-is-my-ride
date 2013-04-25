/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Yessy
 */
@ManagedBean
@SessionScoped
public class ContrasenaBean {
private String password1;  
    /**
     * Creates a new instance of ContrasenaBean
     */
//    public ContrasenaBean() {
//    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    
}
