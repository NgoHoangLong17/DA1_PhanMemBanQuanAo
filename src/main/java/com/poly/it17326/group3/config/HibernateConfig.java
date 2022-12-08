/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.config;


import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.ChucVu;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.domainmodels.HoaDonChiTiet;
import com.poly.it17326.group3.domainmodels.KhachHang;
import com.poly.it17326.group3.domainmodels.KhuyenMai;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.NhanVien;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author longnh203
 */
public class HibernateConfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=QUANLYBANQUANAO");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456789");
        properties.put(Environment.SHOW_SQL, "true");
        conf.setProperties(properties);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(ChiTietSp.class);
     
        conf.addAnnotatedClass(DongSp.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(ChatLieu.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(Size.class);
        conf.addAnnotatedClass(Nsx.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(KhachHang.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
