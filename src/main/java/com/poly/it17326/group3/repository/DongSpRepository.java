/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.DongSp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class DongSpRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM DongSp";//hsl

    public List<DongSp> getAll() {
        Query query = session.createQuery(fromTable, DongSp.class);
        return query.getResultList();

    }

    public static void main(String[] args) {
        List<DongSp> dongSp = new DongSpRepository().getAll();
        for (DongSp dsp : dongSp) {
            System.out.println(dsp.toString());

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

    public DongSp getOne(int id) {
        String sql = fromTable + " where id=:id";
        Query query = session.createQuery(sql, DongSp.class);
        query.setParameter("id", id);
        return (DongSp) query.getSingleResult();

    }
}
