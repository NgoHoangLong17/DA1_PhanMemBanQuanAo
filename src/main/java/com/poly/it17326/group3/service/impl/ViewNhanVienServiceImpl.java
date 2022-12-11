/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.NhanVien;
import com.poly.it17326.group3.repository.NhanVienRepository;
import com.poly.it17326.group3.service.ViewNhanVienService;
import java.util.List;

/**
 *
 * @author user
 */
public class ViewNhanVienServiceImpl implements ViewNhanVienService{
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

//    @Override
//    public List<ViewNhanVienResponse> getNhanVien() {
//        List<ViewNhanVienResponse> responses = new ArrayList<>();
//        List<NhanVien> list = nhanVienRepository.getAll();
//        
//        for(NhanVien nhanVien : list){
//            ViewNhanVienResponse viewNhanVienReponse = new ViewNhanVienResponse(nhanVien);
//            responses.add(viewNhanVienReponse);
//        }
//        return responses ;
//    }
//    
//    public static void main(String[] args) {
//        List<ViewNhanVienResponse> lists = new ViewNhanVienServiceImpl().getNhanVien();
//        for (ViewNhanVienResponse v : lists) {
//            System.out.println(v.toString());
//    }
//    }

    @Override
    public List<NhanVien> getNhanVien() {
        return nhanVienRepository.getAll();
    }

    @Override
    public Boolean them(NhanVien nhanVien) {
        return nhanVienRepository.add(nhanVien);
    }

    @Override
    public Boolean sua(NhanVien nhanVien) {
        return nhanVienRepository.update(nhanVien);
    }

    @Override
    public Boolean xoa(NhanVien nhanVien) {
        return nhanVienRepository.delete(nhanVien);
    }

    @Override
    public NhanVien getOne(Integer id) {
        return nhanVienRepository.getOne(id);
    }

}
