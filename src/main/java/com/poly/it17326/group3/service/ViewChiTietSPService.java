/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;


import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doand
 */
public interface ViewChiTietSPService {

    public ArrayList<ChiTietSp> getAll();



    public List<SanPham> getSanPham();

    public List<ChatLieu> getChatLieu();

    public List<DongSp> getDongSp();

    public List<Size> getSize();

    public List<Nsx> getNsx();

    public List<MauSac> getMauSac();

    public Boolean add(ChiTietSp chiTietSp);

    public Boolean update(ChiTietSp chiTietSp);

    public Boolean delete(ChiTietSp chiTietSp);

    public ChiTietSp getOne(int id);
}
