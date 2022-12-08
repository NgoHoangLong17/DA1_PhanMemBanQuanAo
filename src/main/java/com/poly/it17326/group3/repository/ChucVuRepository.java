/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.ChucVu;
import com.poly.it17326.group3.response.ViewChucVuResponse;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class ChucVuRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM ChucVu";
    
    public List<ChucVu>getAll(){
        Query query = session.createQuery(fromTable, ChucVu.class);
        return query.getResultList(); 
    }
    
    public Boolean add(ChucVu chucVu){
        Transaction transaction= null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean update(ChucVu chucVu){
        Transaction transaction= null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(chucVu);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean delete(ChucVu chucVu){
        Transaction transaction= null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        List<ChucVu> chucVus = new ChucVuRepository().getAll();
        for (ChucVu chucVu :chucVus){
            System.out.println(chucVu.toString());
        }
    }
            
}
