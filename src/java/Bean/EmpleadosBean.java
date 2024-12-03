/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.EmpleadosDao;
import DAO.EmpleadosDaoImplement;
import Modelo.Empleados;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author vane_
 */
@ManagedBean
@ViewScoped
public class EmpleadosBean {


    private Empleados empleado;
    private List<Empleados> empleados;


    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public List<Empleados> getEmpleados() {
        EmpleadosDao dao = new EmpleadosDaoImplement();
        empleados = dao.mostrarEmpleado();
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }

    /**
     * Creates a new instance of EmpleadosBean
     */
    public EmpleadosBean() {
        empleado = new Empleados();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void insertar() {//El nombre del metodo se inicia con minuscula para que se detecte como metodo
        EmpleadosDao dao = new EmpleadosDaoImplement();//Instancia 
        dao.insertarEmpleado(empleado);//Metodo del DaoImplement
        empleado = new Empleados();
        addMessage("Empleado agregado");
        
    }

    public void modificar() {//se inicia con minuscula para que se detecte como metodo
        EmpleadosDao dao = new EmpleadosDaoImplement();//Instancia 
        dao.modificarEmpleado(empleado);//Metodo del DaoImplement
        empleado = new Empleados();
        addMessage("Empleado actualizado");
    }

    public void eliminar() {//se inicia con minuscula para que se detecte como metodo
        EmpleadosDao dao = new EmpleadosDaoImplement();//Instancia 
        dao.eliminarEmpleado(empleado);//Metodo del DaoImplement
        empleado = new Empleados();
        addMessage("Empleado eliminado");
    }


}
