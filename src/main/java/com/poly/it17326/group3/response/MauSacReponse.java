/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.response;


import com.poly.it17326.group3.domainmodels.MauSac;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author doand
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MauSacReponse {

    private int id;
    private String ten;

    public MauSacReponse(MauSac mauSac) {
        this.id = mauSac.getId();
        this.ten = mauSac.getTen();
    }
    


}
