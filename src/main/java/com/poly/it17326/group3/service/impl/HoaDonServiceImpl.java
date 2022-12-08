/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.repository.HoaDonReposity;
import com.poly.it17326.group3.service.ViewHoaDonService;
import java.util.List;

/**
 *
 * @author longnh203
 */
public class HoaDonServiceImpl implements ViewHoaDonService {

    private HoaDonReposity hoaDonReposity = new HoaDonReposity();

    @Override
    public List<HoaDon> getAll() {
        return hoaDonReposity.getAll();
    }

    @Override
    public HoaDon getOne(int id) {
        return hoaDonReposity.getOne(id);
    }

    @Override
    public Boolean save(HoaDon hd) {
        return hoaDonReposity.save(hd);
    }

    @Override
    public Boolean update(HoaDon hd) {
        return hoaDonReposity.update(hd);
    }

    @Override
    public Boolean delete(HoaDon hd) {
        return hoaDonReposity.delete(hd);
    }

    @Override
    public List<HoaDon> getHoaDonByIdNV(int idnv) {
        return hoaDonReposity.getHoaDonByIdNV(idnv);
    }

    @Override
    public HoaDon getOneByMaHD(String maHoaDon) {
        return hoaDonReposity.getOneByMaHD(maHoaDon);
    }

    @Override
    public List<HoaDon> getHdWhere(int tt, int id) {
        return hoaDonReposity.getHdWhere(tt, id);
    }
}
