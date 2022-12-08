/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author longnh203
 */
public interface ViewHoaDonChiTietService {

    List<HoaDonChiTiet> getAll();

    Boolean save(HoaDonChiTiet hdct);

    Boolean update(HoaDonChiTiet hdct);

    Boolean delete(HoaDonChiTiet hdct);

    HoaDonChiTiet getOne(int id);

    List<HoaDonChiTiet> getHdctByIdHD(int id);

    HoaDonChiTiet getHdctByIdCtsp(int idctsp);

    HoaDonChiTiet getOne(Integer ID);

}
