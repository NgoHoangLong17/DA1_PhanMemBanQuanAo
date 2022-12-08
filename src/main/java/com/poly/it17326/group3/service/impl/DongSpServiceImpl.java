/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.repository.DongSpRepository;
import java.util.List;
import com.poly.it17326.group3.service.ViewDongSpService;

/**
 *
 * @author ADMIN
 */
public class DongSpServiceImpl implements ViewDongSpService {

    public DongSpRepository dongSpRepository = new DongSpRepository();

    @Override
    public List<DongSp> getAll() {
        return dongSpRepository.getAll();
    }

    @Override
    public Boolean add(DongSp dongSp) {
        return dongSpRepository.add(dongSp);
    }

    @Override
    public Boolean delete(DongSp dongSp) {
        return dongSpRepository.delete(dongSp);
    }

    @Override
    public boolean update(DongSp dongSp) {
        return dongSpRepository.update(dongSp);
    }

    @Override
    public DongSp getOne(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
