//<<<<<<< HEAD
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.poly.it17326.group3.repository;
//
//import com.poly.it17326.group3.config.HibernateConfig;
//import com.poly.it17326.group3.domainmodels.KhuyenMai;
//import java.util.List;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
///**
// *
// * @author longnh203
// */
//public class KhuyenMaiRepository {
//
//    public List<KhuyenMai> getAll() {
//        Session ses = HibernateConfig.getFACTORY().openSession();
//        String HQL = "from KhuyenMai";
//        Query q = ses.createQuery(HQL);
//        return q.getResultList();
//    }
//
//    public Boolean save(KhuyenMai km) {
//        Transaction transaction = null;
//        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
//            transaction=ss.beginTransaction();
//            ss.save(km);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//    
//    public Boolean update(KhuyenMai km) {
//        Transaction transaction = null;
//        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
//            transaction.begin();
//            ss.saveOrUpdate(km);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//    
//    public Boolean delete(KhuyenMai km) {
//        Transaction transaction = null;
//        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
//            transaction= ss.beginTransaction();
//            ss.delete(km);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
////        new KhuyenMaiRepository().save(new KhuyenMai(4, "Giam gia ngay 8-3", 30, null, null));
////        System.out.println(new KhuyenMaiRepository().getAll().toString());
//    }
//}
//=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.KhuyenMai;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author longnh203
 */
public class KhuyenMaiRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM KhuyenMai";
    
    public List<KhuyenMai> getAll() {
        Session ses = HibernateConfig.getFACTORY().openSession();
        String HQL = "from KhuyenMai";
        Query q = ses.createQuery(HQL);
        return q.getResultList();
    }

    public Boolean save(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
            transaction=ss.beginTransaction();
            ss.save(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public Boolean update(KhuyenMai khuyenMai){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(khuyenMai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean delete(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
            transaction= ss.beginTransaction();
            ss.delete(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//    public void auto() {
//        try (Session session = HibernateConfig.getFACTORY().openSession();) {
//            Transaction transaction = session.beginTransaction();
//            String hql = " update KHUYENMAI set TRANGTHAI=0 where GETDATE() between NGAYBATDAU and NGAYKETTHUC \n"
//                    + "update KHUYENMAI set TRANGTHAI=1 where GETDATE() >NGAYKETTHUC \n"
//                    + "update KHUYENMAI set TRANGTHAI=2 where GETDATE() <NGAYBATDAU  ";
//            Query query = session.createQuery(hql);
//            query.executeUpdate();
//            transaction.commit();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }
//    
    public void auto1() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String sql = "update KhuyenMai set TRANGTHAI=0 where GETDATE() between NGAYBATDAU and NGAYKETTHUC and trangthai !=5\n"
                    ;
            transaction = session.beginTransaction();
            Query q = session.createQuery(sql);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void auto2() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String sql = "update KhuyenMai set TRANGTHAI=1 where GETDATE() >NGAYKETTHUC and trangthai !=5\n"
                    ;
            transaction = session.beginTransaction();
            Query q = session.createQuery(sql);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void auto3() {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String sql = "update KhuyenMai set TRANGTHAI=2 where GETDATE() <NGAYBATDAU and trangthai !=5\n"
                    ;
            transaction = session.beginTransaction();
            Query q = session.createQuery(sql);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
     public void autoHuy(String maHoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String sql = "update KhuyenMai set TRANGTHAI=5 where maHoaDon = :ma"
                    ;
            transaction = session.beginTransaction();
            Query q = session.createQuery(sql);
            q.setParameter("ma", maHoaDon);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

     
    public List<KhuyenMai> tim(String Ten) {

        try (Session session = HibernateConfig.getFACTORY().openSession();) {
            String sql = "from KhuyenMai where Ten = :Ten";
            javax.persistence.Query query = session.createQuery(sql);
            query.setParameter("Ten", Ten);
            List<KhuyenMai> listkm = (List<KhuyenMai>) query.getResultList();
            session.close();
            return listkm;
        }

    }

    public KhuyenMai getOne(int trangThai) {
        String sql = fromTable + " where trangThai =: trangThai";
        Query query = session.createQuery(sql, KhuyenMai.class);
        query.setParameter("trangThai", trangThai);
        return (KhuyenMai) query.getSingleResult();
    }
     
     
     

}
//>>>>>>> origin/Dev
