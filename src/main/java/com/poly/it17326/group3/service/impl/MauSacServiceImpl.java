/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.repository.MauSacRepository;
import com.poly.it17326.group3.response.MauSacReponse;
import java.util.ArrayList;
import java.util.List;
import com.poly.it17326.group3.service.ViewMauSacService;

/**
 *
 * @author ADMIN
 */
public class MauSacServiceImpl implements ViewMauSacService {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public Boolean add(MauSac mauSac) {
        return mauSacRepository.add(mauSac);
    }

    @Override
    public Boolean delete(MauSac mauSac) {
        return mauSacRepository.delete(mauSac);

    }

    @Override
    public Boolean update(MauSac mauSac) {
        return mauSacRepository.Update(mauSac);
    }

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public List<MauSacReponse> getAll1() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<MauSacReponse> reponses = new ArrayList<>();
        List<MauSac> lists = mauSacRepository.getAll();
        for (MauSac list : lists) {
            MauSacReponse mauSacReponse = new MauSacReponse(list);
            reponses.add(mauSacReponse);
        }
        return reponses;
    }

    @Override
    public MauSac getOne(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
