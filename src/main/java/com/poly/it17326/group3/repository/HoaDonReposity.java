/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.HoaDon;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author doand
 */
public class HoaDonReposity {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM HoaDon";

    public List<HoaDon> getAll() {
        Query query = session.createQuery(fromTable + " order by id desc", HoaDon.class);
        return query.getResultList();
    }

    public List<HoaDon> getHdWhere(int tt, int id) {
        Query query = session.createQuery(fromTable + "  where trangThai =:tt and idNhanVien = :id order by id desc", HoaDon.class);
        query.setParameter("tt", tt);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public Boolean save(HoaDon hoaDon) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(HoaDon hoaDon) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(HoaDon hoaDon) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDon getOne(int id) {
        String sql = fromTable + " where id=:id";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("id", id);
        return (HoaDon) query.getSingleResult();
    }

    public HoaDon getOneByMaHD(String maHoaDon) {
        String sql = fromTable + " where maHoaDon=:maHoaDon";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("maHoaDon", maHoaDon);
        return (HoaDon) query.getSingleResult();
    }

    public List<HoaDon> getHoaDonByIdNV(int maNv) {
        String sql = fromTable + " where idNhanVien=:idnv order by id desc";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("idnv", maNv);
        return query.getResultList();
    }

    public static void main(String[] args) {
        for (HoaDon hoaDon : new HoaDonReposity().getHoaDonByIdNV(1)) {
            System.out.println(hoaDon.toString());
        }
    }
}
