/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.FacturaDao;
import DAO.FacturaDaoImplement;
import Modelo.Factura;
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
public class FacturaBean {
    private Factura factura;
    private List<Factura> facturas;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getFacturas() {
        FacturaDao dao = new FacturaDaoImplement();
        facturas = dao.mostrarFactura();
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
     

    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        factura = new Factura();
    }
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){//El nombre del metodo se inicia con minuscula para que se detecte como metodo
        FacturaDao dao = new FacturaDaoImplement();//Instancia 
        dao.insertarFactura(factura);//Metodo del DaoImplement
        factura = new Factura();
        addMessage("Factura agregada");      
    }
    
    public void modificar(){//se inicia con minuscula para que se detecte como metodo
        FacturaDao dao = new FacturaDaoImplement();//Instancia 
        dao.modificarFactura(factura);//Metodo del DaoImplement
        factura = new Factura();
        addMessage("Factura actualizada");      
    }
    
    public void eliminar(){//se inicia con minuscula para que se detecte como metodo
        FacturaDao dao = new FacturaDaoImplement();//Instancia 
        dao.eliminarFactura(factura);//Metodo del DaoImplement
        factura = new Factura();
        addMessage("Factura eliminada");      
    }
    
}
