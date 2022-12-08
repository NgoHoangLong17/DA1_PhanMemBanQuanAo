/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.response;

import com.poly.it17326.group3.domainmodels.Size;

/**
 *
 * @author ADMIN
 */
public class ViewSizeReponse {

    private Integer ID;
    private String TEN;

    public ViewSizeReponse(Size size) {
        this.ID = size.getId();
        this.TEN = size.getTen();
    }

    public ViewSizeReponse() {
    }
}
