/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.domainmodels;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "NHANVIEN")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="MaNV")
    private String maNV;
    
    @Column(name ="cccd")
    private String cccd;
    
    @Column(name = "ten")
    private String tenNhanVien;
    
    @Column(name = "gioiTinh")
    private Boolean gioiTinh;
    
    @Column(name = "ngaySinh")
    private Date ngaySinh;
    
    @Column(name = "SDT")
    private String SDT;
    
    @Column(name = "diaChi")
    private String diaChi;
    
    @Column(name = "matKhau")
    private String matKhau;
    
    @Column(name = "trangThai")
    private Boolean trangThai;
    
    @Column(name = "Email")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "IdChucVu",referencedColumnName = "id" )
    private ChucVu chucVu;
    
    public String htGioiTinh(){
        if(gioiTinh == true){
            return "Nam";
        }else{
            return "Nữ";
        }
    }
    
    public  String htDeleted(){
        if(trangThai == true){
            return "Nghỉ làm";
        }else{
            return "Đang hoạt động";
        }
    }
}
