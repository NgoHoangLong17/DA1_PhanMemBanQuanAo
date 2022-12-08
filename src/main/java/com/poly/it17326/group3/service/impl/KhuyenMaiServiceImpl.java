/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.KhuyenMai;
import com.poly.it17326.group3.repository.KhuyenMaiRepository;
import com.poly.it17326.group3.service.ViewKhuyenMaiService;
import java.util.List;

/**
 *
 * @author longnh203
 */
public class KhuyenMaiServiceImpl implements ViewKhuyenMaiService{

    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public Boolean save(KhuyenMai km) {
        return khuyenMaiRepository.save(km);
    }

    @Override
    public Boolean update(KhuyenMai km) {
        return khuyenMaiRepository.update(km);
    }

    @Override
    public Boolean delete(KhuyenMai km) {
        return khuyenMaiRepository.delete(km);
    }

    @Override
    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();
    }
    
}
