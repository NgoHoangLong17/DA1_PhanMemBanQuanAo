/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.domainmodels.KhachHang;
import com.poly.it17326.group3.service.ViewKhachHangService;
import com.poly.it17326.group3.service.impl.KhachHangServiceImpl;

/**
 *
 * @author longnh203
 */

public class ChonKhachHang {
    static ViewKhachHangService khachHangService = new KhachHangServiceImpl();

    public static KhachHang kh = khachHangService.getOne(1);

    public ChonKhachHang() {

    }

    public static KhachHang getKhachHang() {
        return kh;
    }

    public static void setKhachHang(KhachHang kh) {
        ChonKhachHang.kh = kh;
    }
}
