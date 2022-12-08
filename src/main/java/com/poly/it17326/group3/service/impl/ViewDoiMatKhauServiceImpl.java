/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.NhanVien;
import com.poly.it17326.group3.repository.DoiMatKhauRepository;
import com.poly.it17326.group3.service.ViewDoiMatKhauService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ViewDoiMatKhauServiceImpl implements ViewDoiMatKhauService{
        DoiMatKhauRepository change = new DoiMatKhauRepository();


    @Override
    public List<NhanVien> getPassword(String ma, String MatKhau) {
        //   
        if (change.getPassword(ma, MatKhau).isEmpty()) {
            return null;
        } else {
            return change.getPassword(ma, MatKhau);
        }

    }

    @Override
    public String changePassword(String ma, String MatKhau) {
        return change.changePassword(ma, MatKhau);
    }

    @Override
    public NhanVien getMa(String ma) {
        return change.getMa(ma);
    }
}
