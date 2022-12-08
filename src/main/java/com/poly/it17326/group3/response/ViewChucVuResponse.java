    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.response;

import com.poly.it17326.group3.domainmodels.ChucVu;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class ViewChucVuResponse {

    private Integer id;
    private String ten;

    public ViewChucVuResponse(ChucVu chucVu) {
        this.id = chucVu.getId();
        this.ten = chucVu.getTenChucVu();
    }
}
