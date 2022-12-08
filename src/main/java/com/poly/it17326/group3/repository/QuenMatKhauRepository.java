/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.NhanVien;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class QuenMatKhauRepository {
    
    private Session session1 = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM NhanVien";

    public List<NhanVien> getAll() {
        Query query = session1.createQuery(fromTable, NhanVien.class);
        return query.getResultList();
    }

    public NhanVien getID(int id) {
        String sql = fromTable + "WHERE id =: id";
        Query query = session1.createQuery(sql, NhanVien.class);
        query.setParameter("id", id);

        return (NhanVien) query.getSingleResult();
    }

    public NhanVien getEmail(String email) {
        String sql = fromTable + "WHERE email =: email";
        Query query = session1.createQuery(sql, NhanVien.class);
        query.setParameter("id", email);

        return (NhanVien) query.getSingleResult();
    }

    public NhanVien getPassword(String password) {
        String sql = fromTable + "WHERE MatKhau =: MatKhau";
        Query query = session1.createQuery(sql, NhanVien.class);
        query.setParameter("MatKhau", password);

        return (NhanVien) query.getSingleResult();
    }

    public String changePassword(String email, String matKhau) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String sql = "update NhanVien set MatKhau =:MatKhau where Email =:Email";
            Query query = session.createQuery(sql);
            query.setParameter("MatKhau", matKhau);
            query.setParameter("Email", email);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
