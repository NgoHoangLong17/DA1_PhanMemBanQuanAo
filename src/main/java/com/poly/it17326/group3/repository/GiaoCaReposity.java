/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.GiaoCa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author doand
 */
public class GiaoCaReposity {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM GiaoCa";//hsl

    public List<GiaoCa> getAll() {
        Query query = session.createQuery(fromTable, GiaoCa.class);
        return query.getResultList();

    }

    public static void main(String[] args) {
        List<GiaoCa> gcs = new GiaoCaReposity().getAll();
        for (GiaoCa gc : gcs) {
            System.out.println(gc.toString());
        }

    }

    public Boolean add(DongSp dongSp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dongSp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public Boolean delete(DongSp dongSp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongSp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public Boolean update(DongSp dongSp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(dongSp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
}
