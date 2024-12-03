/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empleados;
import java.util.List;

/**
 *
 * @author vane_
 */
public interface EmpleadosDao {
    public void insertarEmpleado(Empleados empleado);
    public void modificarEmpleado(Empleados empleado);
    public void eliminarEmpleado(Empleados empleado);
    public List<Empleados> mostrarEmpleado();
}
