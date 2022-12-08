/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.Nsx;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class NSXRepositpry {

      private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM Nsx"; // HQL
    
    public List<Nsx>getAll(){
        javax.persistence.Query query = session.createQuery(fromTable, Nsx.class);
        return query.getResultList();
    }
    public Nsx getOne(Integer  ID){
        String sql = fromTable + " WHERE ID =:ID ";
        javax.persistence.Query query = session.createQuery(sql, Nsx.class);
        query.setParameter("ID", ID);
        return (Nsx) query.getSingleResult();
    }
    
    public Boolean add(Nsx nsx){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.save(nsx);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    public Boolean update(Nsx nsx){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.saveOrUpdate(nsx);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    public Boolean delete(Nsx nsx){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.delete(nsx);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        List<Nsx> nsxs = new NSXRepositpry().getAll();
        for (Nsx nsx :nsxs){
            System.out.println(nsx.toString());
        }
    }
}
