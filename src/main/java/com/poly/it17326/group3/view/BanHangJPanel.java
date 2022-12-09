/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.domainmodels.HoaDonChiTiet;
import com.poly.it17326.group3.service.ViewChiTietSPService;
import com.poly.it17326.group3.service.ViewHoaDonChiTietService;
import com.poly.it17326.group3.service.ViewHoaDonService;
import com.poly.it17326.group3.service.ViewKhachHangService;
import com.poly.it17326.group3.service.impl.ChiTietSpServiceImpl;
import com.poly.it17326.group3.service.impl.HoaDonChiTietServiceImpl;
import com.poly.it17326.group3.service.impl.HoaDonServiceImpl;
import com.poly.it17326.group3.service.impl.KhachHangServiceImpl;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.poly.it17326.group3.domainmodels.KhachHang;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author longnh203
 */
public class BanHangJPanel extends javax.swing.JPanel implements Runnable, ThreadFactory, Serializable {

    String seletedImagePath = "";
    private DefaultTableModel model;
    String phonImage = "";
    String phoneImagePath = "";
    private WebcamPanel panel = null;
    public Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private DefaultTableModel tableModel;
    private ViewChiTietSPService chiTietSPService;
    private ViewHoaDonService hoaDonService;
    private ViewHoaDonChiTietService hoaDonChiTietService;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private ViewKhachHangService khachHangService;

    /**
     * Creates new form BanHangJPanel
     */
    public BanHangJPanel() {
        initComponents();
        chiTietSPService = new ChiTietSpServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
        hoaDonChiTietService = new HoaDonChiTietServiceImpl();
        khachHangService = new KhachHangServiceImpl();
        loadDataCtsp(chiTietSPService.getAll());
        loadDataHoaDon(hoaDonService.getHoaDonByIdNV(UserLogin.getNhanVien().getId()));
        lblMaHD.setText("");
        loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(-1));
        loadKHHD();
        loadChonHD();
    }

    private String fomartNgay(Date d) {
        return dateFormat.format(d);
    }

    private int getThanhTien() {
        int tien = 0;
        for (int i = 0; i < tblHdct.getRowCount(); i++) {
            tien += Integer.parseInt(tblHdct.getValueAt(i, 8).toString());
        }
        return tien;
    }

    private void taoHd() {
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(genMa(hoaDonService.getAll()));
        hd.setNgayTao(new Date());
        hd.setNhanVien(UserLogin.getNhanVien());
        hd.setTrangThai(0);
        hd.setKhachHang(khachHangService.getOne(1));
        hd.setSdt("Không có");
        hd.setDiaChi("Không có");
        hd.setLyDo("Không có");
//        hd.setKhuyenMai(new KhuyenMai(1, "r", 0, new Date(), new Date()));
        if (hoaDonService.save(hd)) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công!");
        }
        loadDataHoaDon(hoaDonService.getHdWhere(0, UserLogin.getNhanVien().getId()));
        rdoChoThanhToan.setSelected(true);
        tblHoaDon.setRowSelectionInterval(0, 0);
        lblMaHD.setText(getMaHd());
    }

    private int inputSoLuong() {
        try {
            int sl = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng"));
            return sl;
        } catch (Exception e) {

            return -1;
        }

    }

    private void xuatHdDiXin() {

    }

    private String getMaHd() {
        int row = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(row, 1).toString();
        return maHD;
    }

    private void loadDataCtsp(List<ChiTietSp> list) {
        tableModel = (DefaultTableModel) tblCtsp.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[]{
            "STT", "Mã SP", "Tên SP", "Dòng SP", "Màu sắc", "Chất liệu", "Size", "Số lượng", "Đơn giá"
        });
        int i = 1;
        for (ChiTietSp chiTietSp : list) {
            tableModel.addRow(new Object[]{
                i, chiTietSp.getMactsp(), chiTietSp.getSanPham().getTen(),
                chiTietSp.getDongSp().getTen(), chiTietSp.getMauSac().getTen(),
                chiTietSp.getChatLieu().getTen(), chiTietSp.getSize().getTen(),
                chiTietSp.getSoLuongTon(), chiTietSp.getGia()
            });
            i++;
        }
    }

    private void loadDataHoaDon(List<HoaDon> list) {
        tableModel = (DefaultTableModel) tblHoaDon.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[]{
            "STT", "Mã HD", "Tên khách hàng", "Ngày tạo", "Trạng thái"
        });
        int i = 1;
        for (HoaDon hoaDon : list) {
            tableModel.addRow(new Object[]{
                i, hoaDon.getMaHoaDon(), hoaDon.getKhachHang().getTen(),
                fomartNgay(hoaDon.getNgayTao()), hoaDon.htTrangThai()
            });
            i++;
        }
    }

    private void loadDataGioHang(List<HoaDonChiTiet> list) {
        tableModel = (DefaultTableModel) tblHdct.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[]{
            "STT", "Mã SP", "Tên SP", "Màu sắc", "Chất liệu", "Size", "Số lượng", "Đơn giá", "Thành tiền"
        });
        int i = 1;
        for (HoaDonChiTiet hdct : list) {
            tableModel.addRow(new Object[]{
                i, hdct.getChiTietSp().getMactsp(), hdct.getChiTietSp().getSanPham().getTen(),
                hdct.getChiTietSp().getMauSac().getTen(),
                hdct.getChiTietSp().getChatLieu().getTen(),
                hdct.getChiTietSp().getSize().getTen(), hdct.getSoLuong(), hdct.getDONGIA(), hdct.getSoLuong() * hdct.getDONGIA()});
            i++;
        }
    }

    private void xuatHoaDon() {
        try {
            String path = "";
            JFileChooser j = new JFileChooser();
//            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//            int x = j.showSaveDialog(this);
//            if (x == JFileChooser.APPROVE_OPTION) {
//                path = j.getSelectedFile().getPath();
//            }
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path + "c:/pdf/" + getIdHd() + ".pdf"));
            doc.open();

            PdfPTable tbl = new PdfPTable(3);
            tbl.addCell("Ma HD");
            tbl.addCell("Employe name");
            tbl.addCell("Employe Tele");
            for (int i = 0; i < tblHdct.getRowCount(); i++) {
                String id = tblHdct.getValueAt(i, 0).toString();
                String name = tblHdct.getValueAt(i, 1).toString();
                String tele = tblHdct.getValueAt(i, 2).toString();
                tbl.addCell(id);
                tbl.addCell(name);
                tbl.addCell(tele);

            }
            doc.add(tbl);

            doc.close();
        } catch (Exception ex) {
            Logger.getLogger(BanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jplCam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 185));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Result result = null;
            BufferedImage image = null;

            if (webcam.open()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                ex.printStackTrace();
            }
            if (result != null) {
                txtTimKiem.setText(result.getText());
                if (lblMaHD.getText().equals("")) {
                    taoHd();
                    themVaoGioHangQR(result.getText());

                } else {
                    themVaoGioHangQR(result.getText());
                }
                lblThanhTien.setText(getThanhTien() + " đ");
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private void themVaoGioHangQR(String maCtsp) {
        boolean check = true;
        for (HoaDonChiTiet hdct : hoaDonChiTietService.getHdctByIdHD(getIdHd())) {
            if (hdct.getChiTietSp().getMactsp().equals(maCtsp)) {
                check = false;
            }
        }
        if (check) {
            ChiTietSp ctsp = chiTietSPService.getOneByMaCtsp(maCtsp);
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setHoaDon(hoaDonService.getOne(getIdHd()));
            hdct.setChiTietSp(ctsp);
            int sl = inputSoLuong();
            if (sl <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
                return;
            }
            hdct.setSoLuong(sl);
            hdct.setDONGIA(ctsp.getGia());
            hoaDonChiTietService.save(hdct);
            loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
        } else {
            ChiTietSp ctsp = chiTietSPService.getOneByMaCtsp(maCtsp);
            HoaDonChiTiet hdct = hoaDonChiTietService.getHdctByIdCtspAndIdHd(ctsp.getId(), getIdHd());
            int soL = inputSoLuong();
            if (soL < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
                return;
            }
            if (soL == 0) {
                hdct.setSoLuong(soL);
                hoaDonChiTietService.delete(hdct);
                loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
            } else {
                hdct.setSoLuong(soL);
                hoaDonChiTietService.update(hdct);
                loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
            }

        }

    }

    private int getIdHd() {

        String maHD = lblMaHD.getText();
        int idHd = hoaDonService.getOneByMaHD(maHD).getId();
        return idHd;
    }

    private String genMa(List<HoaDon> list) {
        return "HD" + list.size();

    }

    private int ranDom() {
        //Vòng lặp in ra 5 số ngẫu nhiên
        for (int i = 0; i < 5; i++) {
            int ranNum = ThreadLocalRandom.current().nextInt(10000, 99999);
            System.out.println("Random number is " + ranNum);
            return ranNum;
        }
        return 0;
    }

    private int getIdKHByMa() {
        for (KhachHang kh : khachHangService.getAll()) {
            if (kh.getMa().equals(lblMaKH.getText())) {
                return kh.getId();
            }
        }
        return 1;
    }

    private void loadKHHD() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (ChonKhachHang.getKhachHang().getId() == 1) {
                        lblTenKH.setText(ChonKhachHang.getKhachHang().getTen());
                        lblMaKH.setText("Khách lẻ");

                    } else {
                        lblTenKH.setText(ChonKhachHang.getKhachHang().getTen() + "   Rank:" + ChonKhachHang.getKhachHang().capbac());
                        lblMaKH.setText(ChonKhachHang.getKhachHang().getMa());
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }.start();
    }

    private void loadChonHD() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (ChonKhuyenMai.getKhuyenMai() != null) {
                        lblMaGiamGia.setText(ChonKhuyenMai.getKhuyenMai().getMa());
                        HoaDon hd = hoaDonService.getOneByMaHD(getMaHd());
                        txtGiamGia.setText((hd.getTongTien() * ChonKhuyenMai.getKhuyenMai().getMucGiamGia() / 100) + "");
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }.start();
    }

    private void thanhToan() {
        HoaDon hd = hoaDonService.getOneByMaHD(lblMaHD.getText());
        hd.setNgayThanhToan(new Date());
        hd.setHinhThucThanhToan(cboHinhThucThanhToan.getSelectedIndex());
        hd.setTongTien(getThanhTien());
        hd.setKhachHang(khachHangService.getOne(1));
        hd.setNhanVien(UserLogin.getNhanVien());
        hd.setKhachHang(ChonKhachHang.getKhachHang());
        if (cboHinhThucThanhToan.getSelectedItem().toString().equalsIgnoreCase("Tiền mặt")) {
            hd.setTienKhachTra(getThanhTien());
        } else if (cboHinhThucThanhToan.getSelectedItem().toString().equalsIgnoreCase("Chuyển khoản")) {
            hd.setTienKhachChuyenKhoan(getThanhTien());
        } else {
            hd.setTienKhachTra(Integer.parseInt(txtKhachTra.getText()));
            hd.setTienKhachChuyenKhoan(Integer.parseInt(txtChuyenKhoan.getText()));
        }
        hd.setTrangThai(1);
        if (hoaDonService.update(hd)) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            loadDataHoaDon(hoaDonService.getHdWhere(1, UserLogin.getNhanVien().getId()));
            rdoDaThanhToan.setSelected(true);
        }
    }

    private void newForm() {
        cboHinhThucThanhToan.setSelectedIndex(0);
        lblMaHD.setText("");
        txtGiamGia.setText("");
        txtKhachTra.setText("");
        txtChuyenKhoan.setText("");
        txtTienThua.setText("");
        lblThanhTien.setText("0 đ");
        loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(-1));
        lblTenKH.setText("");
        loadDataCtsp(chiTietSPService.getAll());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHdct = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCtsp = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jplCam = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTenKH = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtKhachTra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtChuyenKhoan = new javax.swing.JTextField();
        btnHoaDonTreo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblMaGiamGia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        lblMaKH = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel1.setText("Danh sách hóa đơn");

        rdoTatCa.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTatCaMouseClicked(evt);
            }
        });

        rdoChoThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chờ thanh toán");
        rdoChoThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChoThanhToanMouseClicked(evt);
            }
        });

        rdoDaThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã thanh toán");
        rdoDaThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaThanhToanMouseClicked(evt);
            }
        });

        rdoDaHuy.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoDaHuy);
        rdoDaHuy.setText("Đã hủy");
        rdoDaHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaHuyMouseClicked(evt);
            }
        });
        rdoDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(108, 108, 108)
                .addComponent(rdoTatCa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoChoThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoDaThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoDaHuy)
                .addContainerGap(263, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoChoThanhToan)
                    .addComponent(rdoDaThanhToan)
                    .addComponent(rdoDaHuy)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Giỏ hàng");

        tblHdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblHdct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHdctMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHdct);

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setText("Làm mới giỏ hàng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Danh sách sản phẩm");

        tblCtsp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCtsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCtspMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCtsp);

        jLabel4.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addComponent(txtTimKiem))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jplCam.setBackground(new java.awt.Color(255, 255, 255));
        jplCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenKH.setText("Khách lẻ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã hóa đơn: ");

        lblMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaHD.setText("1234");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Thành tiền:");

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThanhTien.setText("0 đ");

        btnThanhToan.setBackground(new java.awt.Color(153, 255, 153));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã giảm giá");

        jLabel8.setText("Giảm giá:");

        txtGiamGia.setEditable(false);

        jLabel9.setText("Tiền thừa");

        txtTienThua.setEditable(false);

        jLabel11.setText("Hình thức");

        cboHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Kết hợp" }));
        cboHinhThucThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHinhThucThanhToanItemStateChanged(evt);
            }
        });

        jLabel12.setText("Khách trả");

        txtKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachTraKeyReleased(evt);
            }
        });

        jLabel13.setText("Chuyển khoản");

        txtChuyenKhoan.setEditable(false);

        btnHoaDonTreo.setBackground(new java.awt.Color(255, 204, 204));
        btnHoaDonTreo.setText("Hóa đơn treo");
        btnHoaDonTreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonTreoActionPerformed(evt);
            }
        });

        jButton2.setText("Chọn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblMaGiamGia.setText("Mã");

        jLabel10.setText("Khách");

        jButton5.setText("Chọn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        lblMaKH.setText("Lẻ");

        jButton6.setText("Load");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiamGia)
                            .addComponent(cboHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lblMaGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtKhachTra)
                            .addComponent(txtChuyenKhoan)
                            .addComponent(txtTienThua)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(lblMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHoaDonTreo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2)
                    .addComponent(lblMaGiamGia))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jButton5)
                    .addComponent(lblMaKH))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblThanhTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHoaDonTreo)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jplCam, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jplCam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (lblMaHD.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được chọn!");
            return;
        }
        if (tblHdct.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không có gì trong giỏ hàng!");
            return;
        }
        thanhToan();
        newForm();
        ChonKhachHang.setKhachHang(khachHangService.getOne(1));
        new KhachHangJpanel().updateRankAll();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        lblMaHD.setText(getMaHd() + "");
        loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
        lblThanhTien.setText(getThanhTien() + " đ");
        HoaDon hd = hoaDonService.getOneByMaHD(getMaHd());
        ChonKhachHang.setKhachHang(hd.getKhachHang());

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblCtspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCtspMouseClicked
        // TODO add your handling code here:
        String maCtsp = tblCtsp.getValueAt(tblCtsp.getSelectedRow(), 1).toString();
        txtTimKiem.setText(maCtsp);

        if (lblMaHD.getText().equals("")) {
            taoHd();
            themVaoGioHangQR(maCtsp);

        } else {
            themVaoGioHangQR(maCtsp);
        }
        lblThanhTien.setText(getThanhTien() + " đ");

    }//GEN-LAST:event_tblCtspMouseClicked

    private void btnHoaDonTreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonTreoActionPerformed
        // TODO add your handling code here:
        lblMaHD.setText("");
        loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(-1));
        loadDataHoaDon(hoaDonService.getHdWhere(0, UserLogin.getNhanVien().getId()));
        loadDataCtsp(chiTietSPService.getAll());
        rdoChoThanhToan.setSelected(true);
        lblThanhTien.setText("0 đ");
    }//GEN-LAST:event_btnHoaDonTreoActionPerformed

    private void tblHdctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHdctMouseClicked
        // TODO add your handling code here:

        int row = tblHdct.getSelectedRow();
        String maCtsp = tblHdct.getValueAt(row, 1).toString();
        HoaDonChiTiet hdct = hoaDonChiTietService.getHdctByIdCtspAndIdHd(chiTietSPService.getOneByMaCtsp(maCtsp).getId(), getIdHd());
        int sl = inputSoLuong();
        if (sl < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
            return;
        }
        hdct.setSoLuong(sl);
        if (hdct.getSoLuong() == 0) {
            hoaDonChiTietService.delete(hdct);
            loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
        } else {
            hoaDonChiTietService.update(hdct);
            loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));

        }
        lblThanhTien.setText(getThanhTien() + " đ");
    }//GEN-LAST:event_tblHdctMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            int xacNhan = JOptionPane.showConfirmDialog(this, "Xóa giỏ hàng?");
            if (xacNhan == JOptionPane.YES_OPTION) {
                for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietService.getHdctByIdHD(getIdHd())) {
                    hoaDonChiTietService.delete(hoaDonChiTiet);
                }
                loadDataGioHang(hoaDonChiTietService.getHdctByIdHD(getIdHd()));
            }
        } catch (Exception e) {
        }
        lblThanhTien.setText(getThanhTien() + " đ");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboHinhThucThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHinhThucThanhToanItemStateChanged
        // TODO add your handling code here:
        if (cboHinhThucThanhToan.getSelectedIndex() == 0) {
            txtKhachTra.setEditable(true);//tiền trao cháo múc
            txtKhachTra.setText("");
            txtChuyenKhoan.setText("");
            txtTienThua.setText("");
        } else if (cboHinhThucThanhToan.getSelectedIndex() == 2) {
            txtKhachTra.setEditable(true); //kết hợp
            txtKhachTra.setText("");
            txtChuyenKhoan.setText("");
            txtTienThua.setText("");
        } else {
            txtKhachTra.setEditable(false); //Chuyển khoản
            txtKhachTra.setText("");
            txtChuyenKhoan.setText(getThanhTien() + "");
            txtTienThua.setText("");
        }
    }//GEN-LAST:event_cboHinhThucThanhToanItemStateChanged

    private void txtKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachTraKeyReleased
        // TODO add your handling code here:
        if (cboHinhThucThanhToan.getSelectedIndex() == 0) {
            txtTienThua.setText((Integer.parseInt(txtKhachTra.getText()) - getThanhTien()) + "");
        } else if (cboHinhThucThanhToan.getSelectedIndex() == 2) {
            txtChuyenKhoan.setText((getThanhTien() - Integer.parseInt(txtKhachTra.getText())) + "");
        } else {
            txtKhachTra.setEditable(false); //Chuyển khoản
            txtKhachTra.setText("");
            txtChuyenKhoan.setText(getThanhTien() + "");
            txtTienThua.setText("");
        }
    }//GEN-LAST:event_txtKhachTraKeyReleased

    private void rdoDaHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaHuyMouseClicked
        // TODO add your handling code here:
//        xuatHoaDon();
    }//GEN-LAST:event_rdoDaHuyMouseClicked

    private void rdoDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaHuyActionPerformed
        // TODO add your handling code here:
        loadDataHoaDon(hoaDonService.getHdWhere(2, UserLogin.getNhanVien().getId()));
    }//GEN-LAST:event_rdoDaHuyActionPerformed

    private void rdoTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTatCaMouseClicked
        // TODO add your handling code here:
        loadDataHoaDon(hoaDonService.getHoaDonByIdNV(UserLogin.getNhanVien().getId()));
    }//GEN-LAST:event_rdoTatCaMouseClicked

    private void rdoChoThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChoThanhToanMouseClicked
        // TODO add your handling code here:
        loadDataHoaDon(hoaDonService.getHdWhere(0, UserLogin.getNhanVien().getId()));
    }//GEN-LAST:event_rdoChoThanhToanMouseClicked

    private void rdoDaThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaThanhToanMouseClicked
        // TODO add your handling code here:
        loadDataHoaDon(hoaDonService.getHdWhere(1, UserLogin.getNhanVien().getId()));
    }//GEN-LAST:event_rdoDaThanhToanMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new KhachHangJpanel().updateRankAll();
        new KHJFrame().setVisible(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        lblTenKH.setText(ChonKhachHang.getKhachHang().getTen());
        lblMaKH.setText(ChonKhachHang.getKhachHang().getMa());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new KhuyenMaiJframe().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoaDonTreo;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jplCam;
    private javax.swing.JLabel lblMaGiamGia;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblCtsp;
    private javax.swing.JTable tblHdct;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtChuyenKhoan;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtKhachTra;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
