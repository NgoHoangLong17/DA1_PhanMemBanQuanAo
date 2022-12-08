/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.response;

import com.poly.it17326.group3.domainmodels.NhanVien;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class ViewNhanVienResponse {
    
    private Integer nhanVienId;
    private String tenNhanVien;
    private String tenChucVu;
    private Boolean gioiTinh;
    private Date ngaySinh;
    private String SDT;
    private String diaChi;
    private Boolean deleted;
    
public  ViewNhanVienResponse(NhanVien nhanVien){
    this.nhanVienId = nhanVien.getId();
    this.tenNhanVien = nhanVien.getTenNhanVien();
    this.tenChucVu = nhanVien.getChucVu().getTenChucVu();
    this.gioiTinh = nhanVien.getGioiTinh();
    this.ngaySinh = nhanVien.getNgaySinh();
    this.SDT = nhanVien.getSDT();
    this.diaChi = nhanVien.getDiaChi();
    this.deleted = nhanVien.getTrangThai();
}
    
}
