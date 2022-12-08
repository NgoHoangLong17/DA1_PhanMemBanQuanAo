/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.response.ViewSizeReponse;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ViewSizeService {
     List<Size> getAll();
     
     Boolean save(Size size);

    Boolean update(Size size);

    Boolean delete(Size size);
    
    Size getOne(Integer  ID);
}
