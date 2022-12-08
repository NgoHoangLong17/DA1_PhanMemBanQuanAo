/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;

import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author doand
 */
public class ChiTietSpRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "From ChiTietSp";
    private String fromAnh = "From Anh";
    private String fromSanPham = "From SanPham";
    private String fromChatLieu = "From ChatLieu";
    private String fromDongSp = "From DongSp";
    private String fromSize = "From Size";
    private String fromNsx = "From Nsx";
    private String fromMauSac = "From MauSac";

    public ArrayList<ChiTietSp> getAll() {
        Query query = session.createQuery(fromTable);
        return (ArrayList<ChiTietSp>) query.getResultList();
    }

    public List<SanPham> getSanPham() {
        Query query = session.createQuery(fromSanPham);
        return query.getResultList();
    }

    public List<ChatLieu> getChatLieu() {
        Query query = session.createQuery(fromChatLieu);
        return query.getResultList();
    }

    public List<DongSp> getDongSp() {
        Query query = session.createQuery(fromDongSp);
        return query.getResultList();
    }

    public List<Size> getSize() {
        Query query = session.createQuery(fromSize);
        return query.getResultList();
    }

    public List<Nsx> getNsx() {
        Query query = session.createQuery(fromNsx);
        return query.getResultList();
    }

    public List<MauSac> getMauSac() {
        Query query = session.createQuery(fromMauSac);
        return query.getResultList();
    }

    public Boolean add(ChiTietSp chiTietSp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {

            transaction = session.beginTransaction();
            session.save(chiTietSp);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(ChiTietSp chiTietSp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(chiTietSp);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(ChiTietSp chiTietSp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {

            transaction = session.beginTransaction();
            session.delete(chiTietSp);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSp getOne(int id) {
        String sql = fromTable + " where id=:id";
        Query query = session.createQuery(sql, ChiTietSp.class);
        query.setParameter("id", id);
        return (ChiTietSp) query.getSingleResult();
    }

    public ArrayList<ChiTietSp> getAll1(int id) {
        String sql = fromTable + " where id=:id";
        Query query = session.createQuery(sql, ChiTietSp.class);
        query.setParameter("id", id);
        return (ArrayList<ChiTietSp>) query.getResultList();
    }

    public static void main(String[] args) {
        List<ChiTietSp> list = new ChiTietSpRepository().getAll();
        for (ChiTietSp chiTietSp : list) {
            System.out.println(chiTietSp.toString());
        }
    }
}
