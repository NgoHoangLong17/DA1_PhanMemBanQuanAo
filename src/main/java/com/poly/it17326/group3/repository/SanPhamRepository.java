/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;

import com.poly.it17326.group3.response.SanPhamReponse;

import com.poly.it17326.group3.domainmodels.SanPham;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;





/**
 *
 * @author doand
 */
public class SanPhamRepository {


    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "From SanPham";

    public List<SanPham> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public SanPham getOne(int id) {
        String sql = fromTable + "Where id = :id";
        Query query = session.createQuery(sql, SanPham.class);
        query.setParameter("id", id);
        return (SanPham) query.getSingleResult();
    }

    public Boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {

            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE  SanPham\n"
                    + "SET   Ten = :ten" + " Where id = :id");
            query.setParameter("ten",sanPham.getTen());
            query.setParameter("id",sanPham.getId());
            query.executeUpdate();
            transaction.commit();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
     
    }

    public Boolean Delete(SanPham sanPham) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  

    public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepository().getAll();
        for (SanPham sanPham : list) {
            System.out.println(sanPham.toString());
        }
    }
}
