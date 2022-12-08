/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;


import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.repository.SizeRepository;
import com.poly.it17326.group3.response.ViewNSXReponse;
import com.poly.it17326.group3.response.ViewSizeReponse;
import com.poly.it17326.group3.service.ViewSizeService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SizeServiceImpl implements ViewSizeService{
     private SizeRepository sizeRepository = new SizeRepository();

    @Override
    public List<Size> getAll() {
       return sizeRepository.getAll();
    }

    
    @Override
    public Boolean update(Size size) {
        return sizeRepository.update(size);
    }

    @Override
    public Boolean delete(Size size) {
        return sizeRepository.delete(size);
    }

    @Override
    public Boolean save(Size size) {
        return sizeRepository.add(size);
    }

    @Override
    public Size getOne(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
