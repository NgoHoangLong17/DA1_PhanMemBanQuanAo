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
import javax.persistence.TypedQuery;
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

    public ArrayList<ChiTietSp> getCheckTrung(int idsp, int iddongsp, int idmausac, int idchatlieu, int idsize, int idnsx) {
        Query query = session.createQuery(fromTable + "  where IDSP = :idsp and IDDONGSP =:iddongsp and "
                + "IDMAUSAC =:idmausac and IDCHATLIEU =:idchatlieu and IDSIZE=:idsize and IDNSX =:idnsx");
        query.setParameter("idsp", idsp);
        query.setParameter("iddongsp", iddongsp);
        query.setParameter("idmausac", idmausac);
        query.setParameter("idchatlieu", idchatlieu);
        query.setParameter("idsize", idsize);
        query.setParameter("idnsx", idnsx);
        return (ArrayList<ChiTietSp>) query.getResultList();
    }

    public ArrayList<ChiTietSp> getCheckTonTai(int idsp) {
        Query query = session.createQuery(fromTable + "  INNER JOIN  SanPham on ChiTietSp.id = SanPham.ID \n"
                + "where SanPham.ID = :idsp");
        query.setParameter("idsp", idsp);
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
        String sql = fromTable + " where MACTSP=:id";
        Query query = session.createQuery(sql, ChiTietSp.class);
        query.setParameter("id", id);
        return (ChiTietSp) query.getSingleResult();
    }
    
    public ChiTietSp getOneByMaCtsp(String ma) {
        String sql = fromTable + " where MACTSP=:ma";
        Query query = session.createQuery(sql, ChiTietSp.class);
        query.setParameter("ma", ma);
        return (ChiTietSp) query.getSingleResult();
    }

    public ArrayList<ChiTietSp> getAll1(String id) {
        String sql = fromTable + " where MACTSP=:id";
        Query query = session.createQuery(sql, ChiTietSp.class);
        query.setParameter("id", id);
        return (ArrayList<ChiTietSp>) query.getResultList();
    }

    public static void main(String[] args) {
        List<ChiTietSp> list = new ChiTietSpRepository().getCheckTonTai(1);
        for (ChiTietSp chiTietSp : list) {
            System.out.println(chiTietSp.toString());
        }
    }
    
    //
    public Long ThongKeTong(int ngay, int thang, int nam) {
        Long uuid;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where DAY(ngayThanhToan) =:day \n" +
                            "and MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    //Thống kê Than== thống kê tháng
    public Long ThongKeThan( int thang, int nam) {
        Long uuid;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    
    public List<Long>  ThongKeThang1( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang2( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang3( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang4( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang5( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang6( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang7( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang8( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang9( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang10( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    public List<Long>  ThongKeThang11( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
   public List<Long>  ThongKeThang12( int thang, int nam) {
        
        List<Long> uuid = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "MONTH(ngayThanhToan) =:month and YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
            query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid= query.getResultList();
        }
        return uuid;
    }
    //Thống kê m tháng
    public Long ThongKeNam( int nam) {
        Long uuid;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            //query.setParameter("day", ngay);
           // query.setParameter("month", thang);
          query.setParameter("year", nam);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public List<Long> ThongKeNam1  ( int nam) {
        List<Long> list = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement);
            //query.setParameter("day", ngay);
           // query.setParameter("month", thang);
          query.setParameter("year", nam);
             list= query.getResultList();
        }
        return list;
    }
    public List<Long> ThongKeNam2  ( int nam) {
        List<Long> list = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement);
            //query.setParameter("day", ngay);
           // query.setParameter("month", thang);
          query.setParameter("year", nam);
             list= query.getResultList();
        }
        return list;
    }
    public List<Long> ThongKeNam3  ( int nam) {
        List<Long> list = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement);
            //query.setParameter("day", ngay);
           // query.setParameter("month", thang);
          query.setParameter("year", nam);
             list= query.getResultList();
        }
        return list;
    }
   
    public List<Long> ThongKeNam4  ( int nam) {
        List<Long> list = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select sum(tongTien) from HoaDon where  \n" +
                            "YEAR(ngayThanhToan) =:year";
            TypedQuery<Long> query = session.createQuery(statement);
            //query.setParameter("day", ngay);
           // query.setParameter("month", thang);
          query.setParameter("year", nam);
             list= query.getResultList();
        }
        return list;
    }
}
