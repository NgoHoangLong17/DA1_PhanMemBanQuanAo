/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.repository.MauSacRepository;
import com.poly.it17326.group3.response.MauSacReponse;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ViewMauSacService {

    List<MauSac> getAll();

    List<MauSacReponse> getAll1();

    public Boolean add(MauSac mauSac);

    public Boolean delete(MauSac mauSac);

    public Boolean update(MauSac mauSac);

     MauSac getOne(Integer  ID);
}
