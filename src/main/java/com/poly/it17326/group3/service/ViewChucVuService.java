/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.ChucVu;
import java.util.List;

/**
 *
 * @author user
 */
public interface ViewChucVuService {
    List<ChucVu>getChucVu();
    
    Boolean them(ChucVu chucVu);
    
    Boolean sua(ChucVu chucVu);
    
    Boolean xoa(ChucVu chucVu);
}
