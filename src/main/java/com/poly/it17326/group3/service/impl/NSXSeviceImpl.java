/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.repository.NSXRepositpry;
import com.poly.it17326.group3.response.ViewNSXReponse;
import com.poly.it17326.group3.service.ViewNSXService;
import com.poly.it17326.group3.service.ViewNSXService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NSXSeviceImpl implements ViewNSXService{
     private NSXRepositpry nSXRepositpry = new NSXRepositpry();

    @Override
    public List getNSX() {
         return nSXRepositpry.getAll();
    }

    @Override
    public Boolean save(Nsx nsx) {
        return nSXRepositpry.add(nsx);
    }

    @Override
    public Boolean update(Nsx nsx) {
        return nSXRepositpry.update(nsx);
    }

    @Override
    public Boolean delete(Nsx nsx) {
        return nSXRepositpry.delete(nsx);
    }

    @Override
    public Nsx getOne(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    
    
}
