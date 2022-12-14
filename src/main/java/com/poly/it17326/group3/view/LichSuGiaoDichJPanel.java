/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChucVu;
import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.domainmodels.HoaDonChiTiet;
import com.poly.it17326.group3.domainmodels.NhanVien;
import com.poly.it17326.group3.repository.NhanVienRepository;
import com.poly.it17326.group3.service.ViewHoaDonChiTietService;
import com.poly.it17326.group3.service.ViewHoaDonService;
import com.poly.it17326.group3.service.ViewNhanVienService;
import com.poly.it17326.group3.service.impl.HoaDonChiTietServiceImpl;
import com.poly.it17326.group3.service.impl.HoaDonServiceImpl;
import com.poly.it17326.group3.service.impl.ViewNhanVienServiceImpl;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class LichSuGiaoDichJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LichSuGiaoDichJPanel
     */
    private ViewHoaDonService hoaDonService = new HoaDonServiceImpl();
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private ViewHoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();
    private ViewNhanVienService nhanVienService = new ViewNhanVienServiceImpl();

    public LichSuGiaoDichJPanel() {
        initComponents();
        loadDataHoaDon(hoaDonService.getAll());
        loadCbo();
        
    }

    private void loadDataGioHang(List<HoaDonChiTiet> list) {
        model = (DefaultTableModel) Tblhoadon.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{
            "STT", "M?? SP", "T??n SP", "M??u s???c", "Ch???t li???u", "Size", "S??? l?????ng", "????n gi??", "Th??nh ti???n"
        });
        int i = 1;
        for (HoaDonChiTiet hdct : list) {
            model.addRow(new Object[]{
                i, hdct.getChiTietSp().getMactsp(), hdct.getChiTietSp().getSanPham().getTen(),
                hdct.getChiTietSp().getMauSac().getTen(),
                hdct.getChiTietSp().getChatLieu().getTen(),
                hdct.getChiTietSp().getSize().getTen(), hdct.getSoLuong(), hdct.getDONGIA(), hdct.getSoLuong() * hdct.getDONGIA()});
            i++;
        }
    }

    public void loadData(List<HoaDon> list) {
        model = (DefaultTableModel) Tbllichsu.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{
            "M?? NV", "T??n NV", "M?? KH", "Ng??y T???o", "Khuy???n M???i", "Th??nh Ti???n"
        });
        for (HoaDon hd : list) {
            Object[] row = new Object[]{hd.getNhanVien().getMaNV(), hd.getNhanVien().getTenNhanVien(), hd.getKhachHang().getId(), hd.getNgayTao(), hd.getTienSauGiamGia()};
            model.addRow(row);
        }
    }
    private void loadCbo() {
        DefaultComboBoxModel defaultComboBoxModel;
        defaultComboBoxModel = (DefaultComboBoxModel) Cbmanv.getModel();
        defaultComboBoxModel.removeAllElements();
        for (NhanVien nhanVien : nhanVienService.getNhanVien()) {
            defaultComboBoxModel.addElement(nhanVien.getMaNV());
        }
    }
    private void loadDataHoaDon(List<HoaDon> list) {
        model1 = (DefaultTableModel) Tbllichsu.getModel();
        model1.setRowCount(0);
        model1.setColumnIdentifiers(new String[]{
            "STT","M?? NV", "M?? HD", "T??n kh??ch h??ng", "Ng??y t???o", "Tr???ng th??i"
        });
        int i = 1;
        for (HoaDon hoaDon : list) {
            model1.addRow(new Object[]{
                i, hoaDon.getMaHoaDon(),hoaDon.getNhanVien().getMaNV(), hoaDon.getKhachHang().getTen(),
                fomartNgay(hoaDon.getNgayTao()), hoaDon.htTrangThai()
            });
            i++;
        }
    }

    private String fomartNgay(Date d) {
        return dateFormat.format(d);
    }

    public void loadDatals(List<HoaDon> list) {
        model1 = (DefaultTableModel) Tbllichsu.getModel();
        model1.setRowCount(0);
        model1.setColumnIdentifiers(new Object[]{
            "ID H??", "M?? NV", "T??n NV", "M?? KH", "T??n KH", "S??T", "?????a Ch???", "Ng??y Mua", "Giao H??ng", "Ng??y Thanh To??n", "Th??nh Ti???n", "Tr???ng Th??i"
        });
        for (HoaDon hd : list) {
            Object[] row = new Object[]{hd.getId(), hd.getNhanVien().getMaNV(), hd.getNhanVien().getTenNhanVien(), hd.getKhachHang().getId(), hd.getKhachHang().getTen(),
                hd.getSdt(), hd.getKhachHang().getDiaChi(), hd.getNgayTao(), hd.getHinhThucGiaoHang(), hd.getNgayThanhToan(), hd.getKhuyenMai().getMucGiamGia(), hd.getTienSauGiamGia(), hd.getTrangThai()};
            model1.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        Cbmanv = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        Btntimkiem = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbllichsu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tblhoadon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        TxtTenKH = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        txtNgayThanhToan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 102));

        Cbmanv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbmanvItemStateChanged(evt);
            }
        });
        Cbmanv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CbmanvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CbmanvMouseEntered(evt);
            }
        });

        Btntimkiem.setText("T??m Ki???m");
        Btntimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtntimkiemMouseClicked(evt);
            }
        });

        jButton2.setText("Xu???t exel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Tbllichsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tbllichsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbllichsuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbllichsu);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(Cbmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btntimkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("L???CH S??? GIAO D???CH");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Chi Ti???t H??a ????n");

        Tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID H??a ????n", "T??n SP", "Gi?? B??n", "S??? L?????ng", "T??n Danh M???c", "Size", "M??u S???c"
            }
        ));
        Tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblhoadonMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Tblhoadon);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FROM H??A ????N");

        jLabel4.setText("Tr???ng Th??i:");

        jLabel5.setText("M?? h??a ????n");

        txtMaHD.setEditable(false);

        jLabel6.setText("T??nNV:");

        jLabel7.setText("T??nKH:");

        jLabel8.setText("Ng??y t???o");

        jLabel11.setText("Th??nh Ti???n:");

        txtTenNV.setEditable(false);

        TxtTenKH.setEditable(false);

        txtNgayTao.setEditable(false);

        txtThanhTien.setEditable(false);

        txtTrangThai.setEditable(false);

        txtNgayThanhToan.setEditable(false);

        jLabel9.setText("Ng??y thanh to??n");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtNgayTao)
                            .addComponent(TxtTenKH)
                            .addComponent(txtTrangThai)
                            .addComponent(txtMaHD)
                            .addComponent(txtTenNV)
                            .addComponent(txtThanhTien))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblhoadonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_TblhoadonMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String CurentDirectoryFilePath = "C:\\pdf";
        JFileChooser execlExportChooser = new JFileChooser(CurentDirectoryFilePath);
        FileNameExtensionFilter excelFNEF = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        execlExportChooser.setFileFilter(excelFNEF);
        execlExportChooser.setDialogTitle("Save excel... ");

        int excelChooser = execlExportChooser.showSaveDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook exceSSFWorkbookExprort = new XSSFWorkbook();
            XSSFSheet excelSheet = exceSSFWorkbookExprort.createSheet("Danh Sach");
            for (int i = 0; i < model1.getRowCount(); i++) {
                XSSFRow excelRow = excelSheet.createRow(i);
                for (int j = 0; j < model1.getColumnCount(); j++) {
                    XSSFCell excelCell = excelRow.createCell(j);
                    excelCell.setCellValue(model1.getValueAt(i, j).toString());
                }

            }
            FileOutputStream excelFIS;
            BufferedOutputStream excelBOU;
            try {
                excelFIS = new FileOutputStream(execlExportChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFIS);
                exceSSFWorkbookExprort.write(excelBOU);
                excelBOU.close();
                exceSSFWorkbookExprort.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CbmanvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbmanvItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_CbmanvItemStateChanged

    private void BtntimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtntimkiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtntimkiemMouseClicked
    private int getIdHd() {

        String maHD = txtMaHD.getText();
        int idHd = hoaDonService.getOneByMaHD(maHD).getId();
        return idHd;
    }

    private String getMaHd() {
        int row = Tbllichsu.getSelectedRow();
        String maHD = Tbllichsu.getValueAt(row, 1).toString();
        return maHD;
    }
    private void TbllichsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbllichsuMouseClicked
        // TODO add your handling code here:
        txtMaHD.setText(Tbllichsu.getValueAt(Tbllichsu.getSelectedRow(), 1) + "");
        loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
        HoaDon hd = hoaDonService.getOneByMaHD(txtMaHD.getText());
        TxtTenKH.setText(hd.getKhachHang().getTen());
        txtTrangThai.setText(hd.htTrangThai());
        txtTenNV.setText(hd.getNhanVien().getTenNhanVien());
        txtNgayTao.setText(fomartNgay(hd.getNgayTao()));
        txtNgayThanhToan.setText(fomartNgay(hd.getNgayThanhToan()));
        txtThanhTien.setText(hd.getTongTien()+"");
    }//GEN-LAST:event_TbllichsuMouseClicked

    private void CbmanvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbmanvMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CbmanvMouseClicked

    private void CbmanvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbmanvMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CbmanvMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btntimkiem;
    private javax.swing.JComboBox<String> Cbmanv;
    private javax.swing.JTable Tblhoadon;
    private javax.swing.JTable Tbllichsu;
    private javax.swing.JTextField TxtTenKH;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayThanhToan;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
