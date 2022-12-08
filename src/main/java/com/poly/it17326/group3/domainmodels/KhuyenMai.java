package com.poly.it17326.group3.domainmodels;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author longnh203
 */
@Entity
@Table(name = "KHUYENMAI")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "MUCGIAMGIA")
    private int mucGiamGia;

    @Column(name = "NGAYBATDAU")
    private Date ngayBatDau;

    @Column(name = "NGAYKETTHUC")
    private Date ngayKetThuc;
}