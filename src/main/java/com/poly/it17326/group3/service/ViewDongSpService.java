/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.DongSp;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ViewDongSpService {

    List<DongSp> getAll();

    public Boolean add(DongSp dongSp);

    public Boolean delete(DongSp dongSp);

    public boolean update(DongSp dongSp);

    DongSp getOne(Integer ID);
}
