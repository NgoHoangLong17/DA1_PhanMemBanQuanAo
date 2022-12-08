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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author doand
 */
@Entity
//@Table(name="DONGSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GiaoCa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "thoiGianGiaoCa")
    Date thoiGianGiaoCa;

    @Column(name = "thoiGianNhanCa")
    Date thoiGianNhanCa;

    @ManyToOne
    @JoinColumn(name = "idNhanVienNhanCa", referencedColumnName = "id")
    NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "idNhanVienGiaoCa", referencedColumnName = "id")
    NhanVien nhanVien1;

    @Column(name = "tienBanDau")
    int tienBanDau;

    @Column(name = "tienPhatSinh")
    int tienPhatSinh;

    @Column(name = "giChuPhatSinh")
    String giChuPhatSinh;

    @Column(name = "trangThai")
    int trangThai;
}
