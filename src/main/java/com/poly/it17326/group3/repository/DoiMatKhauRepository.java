/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.NhanVien;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class DoiMatKhauRepository {
    
    private Session session = HibernateConfig.getFACTORY().openSession();

    public List<NhanVien> getPassword(String ma, String MatKhau) {
        Session session = HibernateConfig.getFACTORY().openSession();
        String sql = "FROM NhanVien WHERE  MANV = :Ma and MatKhau =: MatKhau ";
        Query query = session.createQuery(sql);
        query.setParameter("Ma", ma);
        query.setParameter("MatKhau", MatKhau);
        List<NhanVien> tk =  query.getResultList();
        session.close();
        return tk;
    }

    public NhanVien getMa(String ma) {
        String sql = "FROM NhanVien WHERE MANV =: ma";
        Query query = session.createQuery(sql);
        query.setParameter("ma", ma);
        return (NhanVien) query.getSingleResult();
    }

    public String changePassword(String ma, String MatKhau) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String sql = "update NhanVien set MatKhau = :MatKhau where MANV = :ma";
            javax.persistence.Query query = session.createQuery(sql);
            query.setParameter("MatKhau", MatKhau);
            query.setParameter("ma", ma);

            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DoiMatKhauRepository change = new DoiMatKhauRepository();
        for (Object object : change.getPassword("das", "1")) {
            System.out.println(object.toString());
        }
        
    }
}
