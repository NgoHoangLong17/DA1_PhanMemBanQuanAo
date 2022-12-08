/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.ChucVu;
import com.poly.it17326.group3.repository.ChucVuRepository;
import com.poly.it17326.group3.response.ViewChucVuResponse;
import com.poly.it17326.group3.service.ViewChucVuService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ViewChucVuServiceImpl implements ViewChucVuService{
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    
    @Override
    public Boolean them(ChucVu chucVu) {
        return chucVuRepository.add(chucVu);
    }

    @Override
    public Boolean sua(ChucVu chucVu) {
        return chucVuRepository.update(chucVu);
    }

    @Override
    public Boolean xoa(ChucVu chucVu) {
        return chucVuRepository.delete(chucVu);
    }

    @Override
    public List<ChucVu> getChucVu() {
//        List<ChucVu> listCV = new ArrayList<>();
//        List<ChucVu> list = chucVuRepository.getAll();
//        
//        for(ChucVu chucVu : list){
//            ViewChucVuResponse viewChucVuResponse = new ViewChucVuResponse(chucVu);
//            listCV.add(chucVu);
//        }
//        return listCV ;
        return chucVuRepository.getAll();
    }
//        public static void main(String[] args) {
//        List<ChucVu> lists = new ViewChucVuServiceImpl().getChucVu();
//        for (ChucVu v : lists) {
//            System.out.println(v.toString());
//    }
//
//    }    }
        
}
    

