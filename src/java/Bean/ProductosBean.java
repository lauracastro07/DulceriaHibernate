/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ProductoDao;
import DAO.ProductosDaoImplement;
import Modelo.Productos;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ProductosBean {
    private Productos producto;
    private List<Productos> productos;

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public List<Productos> getProductos() {
        ProductoDao dao = new ProductosDaoImplement();
        productos = dao.mostrarProductos();
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
    
    /**
     * Creates a new instance of ProductosBean
     */
    public ProductosBean() {
        producto = new Productos();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){//El nombre del metodo se inicia con minuscula para que se detecte como metodo
        ProductoDao dao = new ProductosDaoImplement();//Instancia 
        dao.insertarProducto(producto);//Metodo del DaoImplement
        producto = new Productos();
        addMessage("Productos agregados");      
    }
    
    public void modificar(){//se inicia con minuscula para que se detecte como metodo
        ProductoDao dao = new ProductosDaoImplement();
        dao.modificarProducto(producto);
        producto = new Productos();
        addMessage("Producto actualizado");      
    }
    
    public void eliminar(){//se inicia con minuscula para que se detecte como metodo
        ProductoDao dao = new ProductosDaoImplement();
        dao.eliminarProducto(producto);
        producto = new Productos();
        addMessage("Producto eliminado");      
    }
}
