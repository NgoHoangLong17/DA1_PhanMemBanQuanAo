/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.repository.SanPhamRepository;
import com.poly.it17326.group3.response.SanPhamReponse;
import com.poly.it17326.group3.domainmodels.SanPham;
import java.util.List;
import com.poly.it17326.group3.service.ViewSanPhamService;

/**
 *
 * @author doand
 */
public class SanPhamServiceImpl implements ViewSanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return sanPhamRepository.getAll();
    }

    @Override
    public Boolean update(SanPham sanPham) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        return true;
    }

    @Override
    public Boolean add(SanPham sanPham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Delete(SanPham sanPham) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return sanPhamRepository.Delete(sanPham);
    }

    @Override
    public SanPham getOne(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
