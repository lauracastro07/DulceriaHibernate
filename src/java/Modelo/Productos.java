package Modelo;
// Generated 12-abr-2023 12:55:10 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.primefaces.component.export.ExporterType;

/**
 * Productos generated by hbm2java
 */
public class Productos  implements java.io.Serializable {


     private int codigo;
     private String nombre;
     private Integer cantidad;
     private Double precio;
     private Date fechaCad;
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Productos() {
    }

	
    public Productos(int codigo) {
        this.codigo = codigo;
    }
    public Productos(int codigo, String nombre, Integer cantidad, Double precio, Date fechaCad, Set<Factura> facturas) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.cantidad = cantidad;
       this.precio = precio;
       this.fechaCad = fechaCad;
       this.facturas = facturas;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Date getFechaCad() {
        return this.fechaCad;
    }
    
    public void setFechaCad(Date fechaCad) {
        this.fechaCad = fechaCad;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }




}


