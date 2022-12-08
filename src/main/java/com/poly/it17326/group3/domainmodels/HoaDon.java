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

/**
 *
 * @author doand
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "HOADON")
@Getter
@Setter
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idNhanVien", referencedColumnName = "id")
    private NhanVien nhanVien;
//    private int idNhanVien;

    @ManyToOne
    @JoinColumn(name = "idKhachHang", referencedColumnName = "id")
    private KhachHang khachHang;
    
    @Column (name="MAHOADON")
    private String maHoaDon;
    
    @Column(name = "sdt")
    private String sdt;

    @Column(name = "ngayTao")
    private Date ngayTao;
    
    @Column(name="DIACHI")
    private String diaChi;
    
    @Column
    private int hinhThucGiaoHang;
    
    @Column
    private int hinhThucThanhToan;
    
    @Column
    private String lyDo;
    
    @Column
    private Date ngayShip;

    @Column(name = "ngayThanhToan")
    private Date ngayThanhToan;
    
    @Column
    private int tienKhachTra;
    
    @Column
    private int tienKhachChuyenKhoan;


    @Column(name = "trangThai")
    private int trangThai;
    
    @Column(name = "tongTien")
    private int tongTien;

    @ManyToOne
    @JoinColumn(name = "idKhuyenMai", referencedColumnName = "id")
    KhuyenMai khuyenMai;

    @Column(name = "tienSauGiamGia")
    private int tienSauGiamGia;
    
    public String htTrangThai(){
        if(this.trangThai==0){
            return "Chờ thanh toán";
        }else if(this.trangThai==1){
            return "Đã thanh toán";
        }else if(this.trangThai==2){
            return "Đã hủy";
        }else if(this.trangThai==3){
            return "Chờ giao hàng";
        }else if(this.trangThai==4){
            return "Đã giao hàng";
        }else if(this.trangThai==5){
            return "Giao hàng thành công";
        }else{
            return null;
        }
    }
}
