/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Productos;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vane_
 */
public class ProductosDaoImplement implements ProductoDao{

    @Override
    //Uso del metodo Session
    public void insertarProducto(Productos producto) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session !=null){
                session.close();
            }
        }
    }

    @Override
    public void modificarProducto(Productos producto) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session !=null){
                session.close();
            }
        }
    }

    @Override
    public void eliminarProducto(Productos producto) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session !=null){
                session.close();
            }
        }
    }

    @Override
    public List<Productos> mostrarProductos() {
        Session session = null;
        List<Productos> lista = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Productos");
            lista = (List<Productos> ) query.list();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }finally{
            if (session !=null){
                session.close();
            }  
        }
        return lista;
    }
    
}
