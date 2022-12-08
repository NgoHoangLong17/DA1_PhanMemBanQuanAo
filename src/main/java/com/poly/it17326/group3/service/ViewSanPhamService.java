/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.SanPham;
import java.util.List;

/**
 *
 * @author doand
 */
public interface ViewSanPhamService {

    public List<SanPham> getAll();

    public Boolean update(SanPham sanPham);

    public Boolean add(SanPham sanPham);
    
    public Boolean Delete(SanPham sanPham);
    
    SanPham getOne(Integer  ID);
     
}
