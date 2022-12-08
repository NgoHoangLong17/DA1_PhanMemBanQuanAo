/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.Nsx;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ViewNSXService {

    List<Nsx> getNSX();

    Boolean save(Nsx nsx);

    Boolean update(Nsx nsx);

    Boolean delete(Nsx nsx);
    
    Nsx getOne(Integer  ID);

}
