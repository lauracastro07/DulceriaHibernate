/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Factura;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author vane_
 */
public class FacturaDaoImplement implements FacturaDao{

    @Override
    public void insertarFactura(Factura factura) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(factura);
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
    public void modificarFactura(Factura factura) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(factura);
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
    public void eliminarFactura(Factura factura) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(factura);
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
    public List<Factura> mostrarFactura() {
        Session session = null;
        List<Factura> lista = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Factura");
            lista = (List<Factura> ) query.list();
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
