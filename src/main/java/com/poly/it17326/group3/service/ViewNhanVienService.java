/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.NhanVien;
import java.util.List;

/**
 *
 * @author user
 */
public interface ViewNhanVienService {
    List<NhanVien> getNhanVien();
    
    Boolean them(NhanVien nhanVien);
    
    Boolean sua(NhanVien nhanVien);
    
    Boolean xoa(NhanVien nhanVien);
}
