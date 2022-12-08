/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.repository.KhachHangRepository;
import com.poly.it17326.group3.response.KhachHangReponse;
import com.poly.it17326.group3.domainmodels.KhachHang;
import java.util.List;
import com.poly.it17326.group3.service.ViewKhachHangService;

/**
 *
 * @author doand
 */
public class KhachHangServiceImpl implements ViewKhachHangService {

    private KhachHangRepository KhachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return KhachHangRepository.getAll();
    }

    @Override
    public Boolean update(KhachHang KhachHang) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return KhachHangRepository.update(KhachHang);
        
    }

    @Override
    public Boolean add(KhachHang KhachHang) {
return  KhachHangRepository.add(KhachHang);
        }

    @Override
    public Boolean Delete(KhachHang KhachHang) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return KhachHangRepository.Delete(KhachHang);
    }

    @Override
    public List<KhachHang> tim(String Ten) {
          return KhachHangRepository.tim(Ten);
    }

    @Override
    public KhachHang getOne(int id) {
        return KhachHangRepository.getOne(id);
    }

//    @Override
//    public Boolean Rank(HoaDon hoaDon) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
