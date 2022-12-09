/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.NhanVien;
import com.poly.it17326.group3.repository.QuenMatKhauRepository;
import com.poly.it17326.group3.service.ViewQuenMatKhauService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class QuenMatKhauServiceImpl implements ViewQuenMatKhauService{
    QuenMatKhauRepository qmkr = new QuenMatKhauRepository();
    @Override
    public List<NhanVien> getAll() {
        return qmkr.getAll();
    }

    @Override
    public String changePassword(String ma, String matKhau) {
    return qmkr.changePassword(ma, matKhau);   
    }

    
}
