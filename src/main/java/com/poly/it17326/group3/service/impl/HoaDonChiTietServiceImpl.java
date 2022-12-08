/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.HoaDonChiTiet;
import com.poly.it17326.group3.repository.HoaDonChiTietReposity;
import com.poly.it17326.group3.service.ViewHoaDonChiTietService;
import java.util.List;

/**
 *
 * @author longnh203
 */
public class HoaDonChiTietServiceImpl implements ViewHoaDonChiTietService {

    private HoaDonChiTietReposity hoaDonChiTietRepository = new HoaDonChiTietReposity();
    
    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.getAll();
    }

    @Override
    public Boolean save(HoaDonChiTiet hdct) {
        return hoaDonChiTietRepository.save(hdct);
    }

    @Override
    public Boolean update(HoaDonChiTiet hdct) {
        return hoaDonChiTietRepository.update(hdct);
    }

    @Override
    public Boolean delete(HoaDonChiTiet hdct) {
        return hoaDonChiTietRepository.delete(hdct);
    }

    @Override
    public HoaDonChiTiet getOne(int id) {
        return hoaDonChiTietRepository.getOne(id);
    }

    @Override
    public List<HoaDonChiTiet> getHdctByIdHD(int id) {
        return hoaDonChiTietRepository.getHdctByIdHd(id);
    }
    public static void main(String[] args) {
        new HoaDonChiTietServiceImpl().getAll().toArray();
    }

    @Override
    public HoaDonChiTiet getHdctByIdCtsp(int idctsp) {
        return hoaDonChiTietRepository.getHdctByIdCtsp(idctsp);
    }

    @Override
    public HoaDonChiTiet getOne(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
