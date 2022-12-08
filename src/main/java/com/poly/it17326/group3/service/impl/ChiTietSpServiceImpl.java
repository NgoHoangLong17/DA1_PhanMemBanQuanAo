/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;


import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.repository.ChiTietSpRepository;
import java.util.ArrayList;
import java.util.List;
import com.poly.it17326.group3.service.ViewChiTietSPService;

/**
 *
 * @author doand
 */
public class ChiTietSpServiceImpl implements ViewChiTietSPService {

    private ChiTietSpRepository chiTietSpRepository = new ChiTietSpRepository();

    @Override
    public ArrayList<ChiTietSp> getAll() {
        return chiTietSpRepository.getAll();
    }

   

    @Override
    public List<SanPham> getSanPham() {
        return chiTietSpRepository.getSanPham();
    }

    @Override
    public List<ChatLieu> getChatLieu() {
        return chiTietSpRepository.getChatLieu();
    }

    @Override
    public List<DongSp> getDongSp() {
        return chiTietSpRepository.getDongSp();
    }

    @Override
    public List<Size> getSize() {
        return chiTietSpRepository.getSize();
    }

    @Override
    public List<Nsx> getNsx() {
        return chiTietSpRepository.getNsx();

    }

    @Override
    public List<MauSac> getMauSac() {
        return chiTietSpRepository.getMauSac();
    }

    @Override
    public Boolean add(ChiTietSp chiTietSp) {
        return chiTietSpRepository.add(chiTietSp);
    }

    @Override
    public Boolean update(ChiTietSp chiTietSp) {
        return chiTietSpRepository.update(chiTietSp);
    }

    @Override
    public Boolean delete(ChiTietSp chiTietSp) {
        return chiTietSpRepository.delete(chiTietSp);
    }

    @Override
    public ChiTietSp getOne(int id) {
        return chiTietSpRepository.getOne(id);
    }

}
