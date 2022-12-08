package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.NhanVien;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NhanVienRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "From NhanVien";

    public List<NhanVien> getAll() {
        Query query = session.createQuery(fromTable, NhanVien.class);
        return query.getResultList();
    }

    public static void main(String[] args) {
        List<NhanVien> nhanViens = new NhanVienRepository().getAll();
        for(NhanVien nhanVien : nhanViens){
            System.out.println(nhanVien.toString());
        }        
    }
    public Boolean add(NhanVien nhanVien) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    
    
}
