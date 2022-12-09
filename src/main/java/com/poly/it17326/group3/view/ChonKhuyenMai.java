/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.domainmodels.KhuyenMai;
import com.poly.it17326.group3.service.ViewKhuyenMaiService;
import com.poly.it17326.group3.service.impl.KhuyenMaiServiceImpl;

/**
 *
 * @author longnh203
 */
public class ChonKhuyenMai {
    static ViewKhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();

    public static KhuyenMai km = null;

    public ChonKhuyenMai() {

    }

    public static KhuyenMai getKhuyenMai() {
        return km;
    }

    public static void setKhuyenMai(KhuyenMai kh) {
        ChonKhuyenMai.km = kh;
    }
}
