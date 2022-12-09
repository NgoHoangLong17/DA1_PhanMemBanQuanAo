/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.NhanVien;
import java.util.Date;
import java.util.List;

/*
 *
 * @author ADMIN
 */
public interface ViewDoiMatKhauService {
       public List<NhanVien> getPassword(String ma,String MatKhau);
    
    public String changePassword(String ma, String MatKhau);
    
    public NhanVien getMa(String ma);
}
