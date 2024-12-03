/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Factura;
import java.util.List;

/**
 *
 * @author vane_
 */
public interface FacturaDao {
    public void insertarFactura(Factura factura);
    public void modificarFactura(Factura factura);
    public void eliminarFactura(Factura factura);
    public List<Factura> mostrarFactura();
}
