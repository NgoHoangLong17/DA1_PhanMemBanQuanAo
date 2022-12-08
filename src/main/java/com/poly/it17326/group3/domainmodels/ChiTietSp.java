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
import javax.persistence.OneToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "CHITIETSP")
public class ChiTietSp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "idSp", referencedColumnName = "id") //categpry
    private SanPham sanPham;
    
    @ManyToOne
    @JoinColumn(name = "idDongSp", referencedColumnName = "id")
    private DongSp dongSp;

    @ManyToOne
    @JoinColumn(name = "idMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idChatLieu", referencedColumnName = "id")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "idSize", referencedColumnName = "id")
    private Size size;
    
    @ManyToOne
    @JoinColumn(name = "idNsx", referencedColumnName = "id")
    private Nsx nsx;

 

    @Column(name = "soLuongTon")
    int soLuongTon;

    @Column(name = "gia")
    int gia;

    @Column(name = "moTa")
    String moTa;
    
    @Column(name = "anh")
    String anh;
}
