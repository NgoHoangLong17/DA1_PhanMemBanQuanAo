/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.repository.KhachHangRepository;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author longnh203 khanh
 */
public class mainJFrame extends javax.swing.JFrame {

    private JPanel jpanel;
    BanHangJPanel banHangJPanel;
    ChiTietSpJpanel chiTietSpJpanel;
    private KhachHangJpanel khachHangJpanel;

    /**
     * Creates new form mainJFrame
     */
    public mainJFrame() {

        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        khachHangJpanel = new KhachHangJpanel();
        dongHo();
        lblTenNV.setText("Tên NV");
        banHangJPanel = new BanHangJPanel();
        chiTietSpJpanel = new ChiTietSpJpanel();
        showPanel(banHangJPanel);
        banHangJPanel.initWebcam();
        defaultHover();
        lblTenNV.setText(UserLogin.getNhanVien().getTenNhanVien());
        lblChucVu.setText(UserLogin.getNhanVien().getChucVu().getTenChucVu());
    }

    private void showPanel(JPanel panel) {
        jpanel = panel;
        jpanel = panel;
        viewPanel.removeAll();
        viewPanel.add(jpanel);
        viewPanel.validate();
    }

    private void hover(JButton btn) {
        btn.setBackground(Color.red);
        btn.setForeground(Color.white);
    }

    private void defaultHover() {
        btnTrangChu.setBackground(Color.white);
        btnTrangChu.setForeground(Color.red);
        btnGiaoCa.setBackground(Color.white);
        btnGiaoCa.setForeground(Color.red);
        btnKhuyenMai.setBackground(Color.white);
        btnKhuyenMai.setForeground(Color.red);
        btnThongKe.setBackground(Color.white);
        btnThongKe.setForeground(Color.red);
        btnQuanLyKH.setBackground(Color.white);
        btnQuanLyKH.setForeground(Color.red);
        btnQuanLySP.setBackground(Color.white);
        btnQuanLySP.setForeground(Color.red);
        btnQuanLyNV.setBackground(Color.white);
        btnQuanLyNV.setForeground(Color.red);
        btnQuanLyKH.setBackground(Color.white);
        btnQuanLyKH.setForeground(Color.red);
        btnLichSuGD.setBackground(Color.white);
        btnLichSuGD.setForeground(Color.red);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void dongHo() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Calendar calendar = Calendar.getInstance();
                        String hour = (calendar.getTime().getHours() > 9)
                                ? "" + calendar.getTime().getHours() + ""
                                : "0" + calendar.getTime().getHours();
                        String minute = (calendar.getTime().getMinutes() > 9)
                                ? "" + calendar.getTime().getMinutes() + ""
                                : "0" + calendar.getTime().getMinutes();
                        String second = (calendar.getTime().getSeconds() > 9)
                                ? "" + calendar.getTime().getSeconds() + ""
                                : "0" + calendar.getTime().getSeconds();
                        lblDongHo.setText(hour + ":" + minute + ":" + second);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDongHo = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnQuanLyKH = new javax.swing.JButton();
        btnLichSuGD = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnGiaoCa = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnQuanLyNV = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        btnQuanLySP = new javax.swing.JButton();
        lblChucVu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        lblDongHo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDongHo.setForeground(new java.awt.Color(255, 255, 0));
        lblDongHo.setText("12:00:00 PM");

        lblThoat.setIcon(new javax.swing.ImageIcon("C:\\Data\\Nhom3_QuanLyBanQuanAo\\nhom3quanlybanquanao\\src\\main\\resources\\com\\poly\\it17326\\group3\\icon\\icons8-macos-close-30.png")); // NOI18N
        lblThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Data\\Nhom3_QuanLyBanQuanAo\\nhom3quanlybanquanao\\src\\main\\resources\\com\\poly\\it17326\\group3\\icon\\icons8-macos-minimize-30.png")); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(469, 469, 469)
                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThoat)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDongHo)
                    .addComponent(jLabel4)
                    .addComponent(lblThoat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewPanel.setBackground(new java.awt.Color(255, 204, 204));
        viewPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnQuanLyKH.setText("Quản lý khách hàng");
        btnQuanLyKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyKHMouseExited(evt);
            }
        });
        btnQuanLyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyKHActionPerformed(evt);
            }
        });

        btnLichSuGD.setText("Lịch sử giao dịch");
        btnLichSuGD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLichSuGDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLichSuGDMouseExited(evt);
            }
        });
        btnLichSuGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSuGDActionPerformed(evt);
            }
        });

        btnKhuyenMai.setText("Quản lý khuyến mại");
        btnKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKhuyenMaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKhuyenMaiMouseExited(evt);
            }
        });
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        btnGiaoCa.setText("Quản lý giao ca");
        btnGiaoCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGiaoCaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGiaoCaMouseExited(evt);
            }
        });
        btnGiaoCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoCaActionPerformed(evt);
            }
        });

        btnTrangChu.setText("Bán hàng");
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
        });
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnThongKe.setText("Thống kê");
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongKeMouseExited(evt);
            }
        });
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnQuanLyNV.setText("Quản lý nhân viên");
        btnQuanLyNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyNVMouseExited(evt);
            }
        });
        btnQuanLyNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNVActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/poly/it17326/group3/icon/icons8-customer-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );

        lblTenNV.setText("TeenNV");

        btnQuanLySP.setText("Quản lý sản phẩm");
        btnQuanLySP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLySPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLySPMouseExited(evt);
            }
        });
        btnQuanLySP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLySPActionPerformed(evt);
            }
        });

        lblChucVu.setText("CV");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLichSuGD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGiaoCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLySP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuanLyKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLichSuGD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuanLyNV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuanLySP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblThoatMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked


    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnQuanLyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyKHActionPerformed
        // TODO add your handling code here:

        showPanel(khachHangJpanel);
        hover(btnQuanLyKH);
        closeWebcam();
        new KhachHangJpanel().loadDatakhachHang(new KhachHangRepository().getAll());
    }//GEN-LAST:event_btnQuanLyKHActionPerformed

    private void btnQuanLyKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKHMouseEntered
        // TODO add your handling code here:
        hover(btnQuanLyKH);
    }//GEN-LAST:event_btnQuanLyKHMouseEntered

    private void btnQuanLyKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKHMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnQuanLyKHMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i < 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnLichSuGDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLichSuGDMouseEntered
        // TODO add your handling code here:
        hover(btnLichSuGD);
    }//GEN-LAST:event_btnLichSuGDMouseEntered

    private void btnLichSuGDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLichSuGDMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnLichSuGDMouseExited

    private void btnLichSuGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichSuGDActionPerformed
        // TODO add your handling code here:
        closeWebcam();
    }//GEN-LAST:event_btnLichSuGDActionPerformed

    private void btnKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMouseEntered
        // TODO add your handling code here:
        hover(btnKhuyenMai);
    }//GEN-LAST:event_btnKhuyenMaiMouseEntered

    private void btnKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnKhuyenMaiMouseExited

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed

        // TODO add your handling code here:
        closeWebcam();


        showPanel(new KhuyenMaiJPanel());

    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnGiaoCaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGiaoCaMouseEntered
        // TODO add your handling code here:
        hover(btnGiaoCa);
    }//GEN-LAST:event_btnGiaoCaMouseEntered

    private void btnGiaoCaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGiaoCaMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnGiaoCaMouseExited

    private void btnGiaoCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoCaActionPerformed
        // TODO add your handling code here:
        closeWebcam();

    }//GEN-LAST:event_btnGiaoCaActionPerformed

    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
        // TODO add your handling code here:
        hover(btnTrangChu);
    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnTrangChuMouseExited
    private void closeWebcam() {
        if (chiTietSpJpanel.webcam != null) {
            chiTietSpJpanel.webcam.close();
        }
        if (banHangJPanel.webcam != null) {
            banHangJPanel.webcam.close();
        }

    }
    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        closeWebcam();
        showPanel(banHangJPanel);
        banHangJPanel.initWebcam();
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseEntered
        // TODO add your handling code here:
        hover(btnThongKe);
    }//GEN-LAST:event_btnThongKeMouseEntered

    private void btnThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnThongKeMouseExited

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        closeWebcam();

    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnQuanLyNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNVMouseEntered
        // TODO add your handling code here:
        hover(btnQuanLyNV);
    }//GEN-LAST:event_btnQuanLyNVMouseEntered

    private void btnQuanLyNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNVMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnQuanLyNVMouseExited

    private void btnQuanLyNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNVActionPerformed
        // TODO add your handling code here:
        closeWebcam();

    }//GEN-LAST:event_btnQuanLyNVActionPerformed

    private void btnQuanLySPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySPMouseEntered
        // TODO add your handling code here:
        hover(btnQuanLySP);
    }//GEN-LAST:event_btnQuanLySPMouseEntered

    private void btnQuanLySPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySPMouseExited
        // TODO add your handling code here:
        defaultHover();
    }//GEN-LAST:event_btnQuanLySPMouseExited

    private void btnQuanLySPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLySPActionPerformed

        showPanel(chiTietSpJpanel);
        closeWebcam();


    }//GEN-LAST:event_btnQuanLySPActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiaoCa;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnLichSuGD;
    private javax.swing.JButton btnQuanLyKH;
    private javax.swing.JButton btnQuanLyNV;
    private javax.swing.JButton btnQuanLySP;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
