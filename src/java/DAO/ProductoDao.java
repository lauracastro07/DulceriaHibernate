/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Productos;
import java.util.List;

/**
 *
 * @author vane_
 */
public interface ProductoDao {
    //Metodo abstracto
    public void insertarProducto(Productos producto);
    public void modificarProducto(Productos producto);
    public void eliminarProducto(Productos producto);
    public List<Productos> mostrarProductos();
}
