/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.service.impl.*;
import com.poly.it17326.group3.service.*;
import com.poly.it17326.group3.domainmodels.KhachHang;
import java.util.List;

/**
 *
 * @author doand
 */
public interface ViewKhachHangService {

    public List<KhachHang> getAll();
    public KhachHang getOne(int id);

    public Boolean update(KhachHang KhachHang);

    public Boolean add(KhachHang KhachHang);
    
    public Boolean Delete(KhachHang KhachHang);
    
    public List<KhachHang> tim(String Ten);
    
    //public Boolean Rank(HoaDon hoaDon);

    
     
}
