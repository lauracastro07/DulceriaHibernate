/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClienteDao;
import DAO.ClienteDaoImplement;
import Modelo.Cliente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ClienteBean {
    private Cliente cliente;
    private List<Cliente> clientes;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        ClienteDao dao = new ClienteDaoImplement();
        clientes = dao.mostrarCliente();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
        cliente = new Cliente();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
        public void insertar(){//El nombre del metodo se inicia con minuscula para que se detecte como metodo
        ClienteDao dao = new ClienteDaoImplement();
        dao.insertarCliente(cliente);
        cliente = new Cliente();
        addMessage("Cliente agregado");      
    }
    
    public void modificar(){//se inicia con minuscula para que se detecte como metodo
        ClienteDao dao = new ClienteDaoImplement();
        dao.modificarCliente(cliente);
        cliente = new Cliente();
        addMessage("Cliente actualizado");      
    }
    
    public void eliminar(){//se inicia con minuscula para que se detecte como metodo
        ClienteDao dao = new ClienteDaoImplement();
        dao.eliminarCliente(cliente);
        cliente = new Cliente();
        addMessage("Cliente eliminado");
    }
    
}
