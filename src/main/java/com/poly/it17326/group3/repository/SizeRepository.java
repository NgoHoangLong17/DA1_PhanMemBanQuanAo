/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.Size;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class SizeRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM Size"; // HQL
    
    public List<Size>getAll(){
        javax.persistence.Query query = session.createQuery(fromTable, Size.class);
        return query.getResultList();
    }
    public Size getOne(Integer  ID){
        String sql = fromTable + " WHERE ID =:ID ";
        javax.persistence.Query query = session.createQuery(sql, Size.class);
        query.setParameter("ID", ID);
        return (Size) query.getSingleResult();
    }
    
    public Boolean add(Size size){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.save(size);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    public Boolean update(Size size){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.saveOrUpdate(size);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    public Boolean delete(Size size){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.delete(size);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    public Size getOne(int id) {
        String sql = fromTable + "where id=:id";
        Query query = session.createQuery(sql, Size.class);
        query.setParameter("id", id);
        return (Size) query.getSingleResult();
    }
    public static void main(String[] args) {
        List<Size> sizes = new SizeRepository().getAll();
        for (Size size :sizes){
            System.out.println(size.toString());
        }
    }
}
