/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.MauSac;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class MauSacRepository {
    
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM MauSac";//hsl
    
    public List<MauSac> getAll(){
        Query query = session.createQuery(fromTable, MauSac.class);
        return  query.getResultList();
    }
    public static void main(String[] args) {
        List<MauSac> mausac = new MauSacRepository().getAll();
        for (MauSac ms : mausac) {
            System.out.println(ms.toString());
            
        }
    }
    
     public Boolean add(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
    
     public Boolean Update(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
     
     public Boolean delete(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
     
     public MauSac getOne(Long id) {
        String sql = fromTable + "where id =:id";
        Query query = session.createQuery(sql, MauSac.class);
        query.setParameter("id", id);
        return (MauSac) query.getSingleResult();
    }
     
}
