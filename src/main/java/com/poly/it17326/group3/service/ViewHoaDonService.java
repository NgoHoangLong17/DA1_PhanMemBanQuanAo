/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.HoaDon;
import java.util.List;

/**
 *
 * @author longnh203
 */
public interface ViewHoaDonService {

    List<HoaDon> getAll();

    HoaDon getOne(int id);
    
    List<HoaDon> getHdWhere(int tt, int id);

    HoaDon getOneByMaHD(String maHoaDon);

    List<HoaDon> getHoaDonByIdNV(int idnv);

    Boolean save(HoaDon hd);

    Boolean update(HoaDon hd);

    Boolean delete(HoaDon hd);

}
