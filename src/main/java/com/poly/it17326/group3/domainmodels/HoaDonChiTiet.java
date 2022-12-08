/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.domainmodels;

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
@Entity
@Table(name = "HOADONCHITIET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idCtSp", referencedColumnName = "id")
    private ChiTietSp chiTietSp;
//      private int idCtSp;

    @ManyToOne
    @JoinColumn(name = "idHoaDon", referencedColumnName = "id")
    private HoaDon hoaDon;
//    private int idHoaDon;

    @Column(name = "tenSp")
    private String tenSp;

    @Column(name = "tenNsx")
    private String tenNsx;

    @Column(name = "dongSp")
    private String dongSp;

    @Column(name = "mauSac")
    private String mauSac;

    @Column(name = "anh")
    private String anh;

    @Column(name = "trangThai")
    private int trangThai;

    @Column(name = "size")
    private String size;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "DONGIA")
    private int DONGIA;

}
