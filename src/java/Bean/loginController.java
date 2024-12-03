/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Empleados;
import Persistencia.NewHibernateUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;

/**
 *
 * @author Laura Castro
 */
@ManagedBean
@ViewScoped
public class loginController {
    private Empleados empleados = new Empleados();
    private Empleados loginEmpleados = new Empleados();
    private Boolean login = false;

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Empleados getLoginEmpleados() {
        return loginEmpleados;
    }

    public void setLoginEmpleados(Empleados loginEmpleados) {
        this.loginEmpleados = loginEmpleados;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }
    
    public String checkEmpleado(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Empleados e =(Empleados) session.get(Empleados.class, empleados.getNumEmpleado());
        if (e!=null && e.getNombre().equals(empleados.getNombre())){
            loginEmpleados.setNumEmpleado(e.getNumEmpleado());
            loginEmpleados.setNombre(e.getNombre());
            loginEmpleados.setCargo(e.getCargo());
            login = true;
            return "index";
        }
        return "Fail";
    }
    
    public loginController() {
    }
    
}
