/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.google.zxing.WriterException;
import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.repository.ChiTietSpRepository;
import com.poly.it17326.group3.repository.SanPhamRepository;
import com.poly.it17326.group3.service.ViewChatLieuService;
import com.poly.it17326.group3.service.ViewDongSpService;
import com.poly.it17326.group3.service.ViewMauSacService;
import com.poly.it17326.group3.service.ViewNSXService;
import com.poly.it17326.group3.service.ViewSizeService;
import com.poly.it17326.group3.service.impl.ChatLieuServiceImpl;
import com.poly.it17326.group3.service.impl.ChiTietSpServiceImpl;
import com.poly.it17326.group3.service.impl.DongSpServiceImpl;
import com.poly.it17326.group3.service.impl.MauSacServiceImpl;
import com.poly.it17326.group3.service.impl.NSXSeviceImpl;
import com.poly.it17326.group3.service.impl.SanPhamServiceImpl;
import com.poly.it17326.group3.service.impl.SizeServiceImpl;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author doand
 */
public class ChiTietSpJpanel1 extends javax.swing.JPanel {

    ChiTietSpServiceImpl chiTietSpServiceImpl = new ChiTietSpServiceImpl();
    private DefaultTableModel model;
    private List<ChiTietSp> list = chiTietSpServiceImpl.getAll();
    private List<ChatLieu> listChatLieu = chiTietSpServiceImpl.getChatLieu();
    private List<Nsx> listNsx = chiTietSpServiceImpl.getNsx();
    private List<MauSac> listMauSac = chiTietSpServiceImpl.getMauSac();
    private List<DongSp> listDongSp = chiTietSpServiceImpl.getDongSp();
    private List<SanPham> listSanPham = chiTietSpServiceImpl.getSanPham();
    private List<Size> listSize = chiTietSpServiceImpl.getSize();
    private ChiTietSpRepository chiTietSpRepository = new ChiTietSpRepository();

    private ViewChatLieuService chatLieuService = new ChatLieuServiceImpl();
    private ViewSizeService sizeService = new SizeServiceImpl();
    private SanPhamServiceImpl sanPhamServiceImpl = new SanPhamServiceImpl();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private ViewDongSpService dongSpService = new DongSpServiceImpl();
    private ViewMauSacService mauSacService = new MauSacServiceImpl();
    private ViewNSXService nSXService = new NSXSeviceImpl();

    /**
     * Creates new form ChiTietSpJpanel1
     */
    public void loadCboSp(List<SanPham> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (SanPham sanPham : list) {
            row.addElement(sanPham.getTen());
        }
        cboSanPham.setModel(row);

    }

    public void loadCboTimSp(List<SanPham> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (SanPham sanPham : list) {
            row.addElement(sanPham.getTen());
        }
        cboTimSp.setModel(row);

    }

    public void loadCboChatLieu(List<ChatLieu> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (ChatLieu chatLieu : list) {
            row.addElement(chatLieu.getTen());
        }
        cboChatLieu.setModel(row);

    }

    public void loadCboTimChatLieu(List<ChatLieu> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (ChatLieu chatLieu : list) {
            row.addElement(chatLieu.getTen());
        }

        cboTimChatLieu.setModel(row);
    }

    public void loadCboDongSp(List<DongSp> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (DongSp dongSp : list) {
            row.addElement(dongSp.getTen());
        }
        cboDongSp.setModel(row);

    }

    public void loadCboTimDongSp(List<DongSp> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (DongSp dongSp : list) {
            row.addElement(dongSp.getTen());
        }

        cboTimDongSp.setModel(row);
    }

    public void loadCboSize(List<Size> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (Size size : list) {
            row.addElement(size.getTen());
        }
        cboSize.setModel(row);

    }

    public void loadCboTimSize(List<Size> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (Size size : list) {
            row.addElement(size.getTen());
        }

        cboTimSize.setModel(row);
    }

    public void loadCboNsx(List<Nsx> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (Nsx nsx : list) {
            row.addElement(nsx.getTen());
        }
        cboNsx.setModel(row);

    }

    public void loadCboTimNsx(List<Nsx> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (Nsx nsx : list) {
            row.addElement(nsx.getTen());
        }

        cboTimNsx.setModel(row);
    }

    public void loadCboMauSac(List<MauSac> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (MauSac mauSac : list) {
            row.addElement(mauSac.getTen());
        }
        cboMauSac.setModel(row);

    }

    public void loadCboTimMauSac(List<MauSac> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (MauSac mauSac : list) {
            row.addElement(mauSac.getTen());
        }

        cboTimMauSac.setModel(row);
    }

    public void loadTableCtSanPham(ArrayList<ChiTietSp> list) {
        model = (DefaultTableModel) tblThongTinSp.getModel();
        model.setRowCount(0);

        model.setColumnIdentifiers(new Object[]{
            //            "id",
            "machitietsp", "chatlieu", "dongsp", "size", "nsx", "mausac", "sanpham", "soluongton", "gia", "mota"
        });
        for (ChiTietSp chiTietSanPham : list) {
            Object[] row = new Object[]{chiTietSanPham.getMactsp(), chiTietSanPham.getChatLieu().getTen(), chiTietSanPham.getDongSp().getTen(),
                chiTietSanPham.getSize().getTen(), chiTietSanPham.getNsx().getTen(), chiTietSanPham.getMauSac().getTen(), chiTietSanPham.getSanPham().getTen(), chiTietSanPham.getSoLuongTon(),
                chiTietSanPham.getGia(), chiTietSanPham.getMoTa()};
            model.addRow(row);
        }
    }

    public void loadTblMau(List<MauSac> list) {
        model = (DefaultTableModel) tblThuocTinh.getModel();
        model.setRowCount(0);
        int i = 1;
        model.setColumnIdentifiers(new Object[]{
            "stt", "ten"
        });
        for (MauSac mauSac : list) {

            Object[] row = new Object[]{
                i, mauSac.getTen()
            };
            i++;
            model.addRow(row);

        }
    }

    public void loadTblSize(List<Size> list) {
        model = (DefaultTableModel) tblThuocTinh.getModel();
        model.setRowCount(0);
        int i = 1;
        model.setColumnIdentifiers(new Object[]{
            "stt", "ten"
        });
        for (Size size : list) {

            Object[] row = new Object[]{
                i, size.getTen()
            };
            i++;
            model.addRow(row);

        }
    }

    public void loadTblDongSp(List<DongSp> list) {
        model = (DefaultTableModel) tblThuocTinh.getModel();
        model.setRowCount(0);
        int i = 1;
        model.setColumnIdentifiers(new Object[]{
            "stt", "ten"
        });
        for (DongSp dongSp : list) {

            Object[] row = new Object[]{
                i, dongSp.getTen()
            };
            i++;
            model.addRow(row);

        }
    }

    public void loadTblNsx(List<Nsx> list) {
        model = (DefaultTableModel) tblThuocTinh.getModel();
        model.setRowCount(0);
        int i = 1;
        model.setColumnIdentifiers(new Object[]{
            "stt", "ten"
        });
        for (Nsx nsx : list) {

            Object[] row = new Object[]{
                i, nsx.getTen()
            };
            i++;
            model.addRow(row);

        }
    }

    public void loadTblSanPham(List<SanPham> list) {
        model = (DefaultTableModel) tblThuocTinh.getModel();
        model.setRowCount(0);
        int i = 1;
        model.setColumnIdentifiers(new Object[]{
            "stt", "ten"
        });
        for (SanPham sanPham : list) {

            Object[] row = new Object[]{
                i, sanPham.getTen()
            };
            i++;
            model.addRow(row);

        }
    }

    public void loadTblChatLieu(List<ChatLieu> list) {
        model = (DefaultTableModel) tblThuocTinh.getModel();
        model.setRowCount(0);
        int i = 1;
        model.setColumnIdentifiers(new Object[]{
            "stt", "ten"
        });
        for (ChatLieu chatLieu : list) {

            Object[] row = new Object[]{
                i, chatLieu.getTen()
            };
            i++;
            model.addRow(row);

        }
    }

    public Boolean checkMauSac() {
        Boolean check = true;
        for (MauSac mauSac : listMauSac) {
            if (mauSac.getTen().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkSize() {
        Boolean check = true;
        for (Size size : listSize) {
            if (size.getTen().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkDongSp() {
        Boolean check = true;
        for (DongSp dongSp : listDongSp) {
            if (dongSp.getTen().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkNsx() {
        Boolean check = true;
        for (Nsx nsx : listNsx) {
            if (nsx.getTen().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkSanPham() {
        Boolean check = true;
        for (SanPham sanPham : listSanPham) {
            if (sanPham.getTen().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkChatLieu() {
        Boolean check = true;
        for (ChatLieu chatLieu : listChatLieu) {
            if (chatLieu.getTen().equalsIgnoreCase(txtTenThuocTinh.getText())) {
                check = false;
            }
        }
        return check;
    }

    public void showdata(int index) {

        index = tblThongTinSp.getSelectedRow();

        txtMaSP.setText(tblThongTinSp.getValueAt(index, 0).toString());
        cboChatLieu.setSelectedItem(tblThongTinSp.getValueAt(index, 1));
        cboDongSp.setSelectedItem(tblThongTinSp.getValueAt(index, 2));
        cboSize.setSelectedItem(tblThongTinSp.getValueAt(index, 3));
        cboNsx.setSelectedItem(tblThongTinSp.getValueAt(index, 4));
        cboMauSac.setSelectedItem(tblThongTinSp.getValueAt(index, 5));
        cboSanPham.setSelectedItem(tblThongTinSp.getValueAt(index, 6));
        txtSoLuongTon.setText(tblThongTinSp.getValueAt(index, 7).toString());
        txtGia.setText(tblThongTinSp.getValueAt(index, 8).toString());
        txtMoTa.setText(tblThongTinSp.getValueAt(index, 9).toString());
    }
    ButtonGroup buttonGroup = new ButtonGroup();

    public void hienThuocTinh() {
        buttonGroup.add(rdoMau);
        buttonGroup.add(rdoSanPham);
        buttonGroup.add(rdoNsx);
        buttonGroup.add(rdoSize);
        buttonGroup.add(rdoDongSp);
        buttonGroup.add(rdoChatLieu);
        buttonGroup.add(rdoDongSp);
    }

 

    public ChiTietSpJpanel1() {
        initComponents();
        loadTableCtSanPham(chiTietSpServiceImpl.getAll());
        loadCboSp(chiTietSpServiceImpl.getSanPham());
        loadCboChatLieu(chiTietSpServiceImpl.getChatLieu());
        loadCboDongSp(chiTietSpServiceImpl.getDongSp());
        loadCboSize(chiTietSpServiceImpl.getSize());
        loadCboNsx(chiTietSpServiceImpl.getNsx());
        loadCboMauSac(chiTietSpServiceImpl.getMauSac());
        hienThuocTinh();

        loadCboTimSp(chiTietSpRepository.getSanPham());
        loadCboTimChatLieu(chiTietSpServiceImpl.getChatLieu());
        loadCboTimDongSp(chiTietSpServiceImpl.getDongSp());
        loadCboTimSize(chiTietSpServiceImpl.getSize());
        loadCboTimNsx(chiTietSpServiceImpl.getNsx());
        loadCboTimMauSac(chiTietSpServiceImpl.getMauSac());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblThongTinChiTiet = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinSp = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnThemCtsp = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        cboSanPham = new javax.swing.JComboBox<>();
        cboDongSp = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
        cboNsx = new javax.swing.JComboBox<>();
        btnXoaCtSp = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnXuatBar = new javax.swing.JButton();
        btnXuatEcel = new javax.swing.JButton();
        btnNhapEcel = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        cboTimNsx = new javax.swing.JComboBox<>();
        cboTimSp = new javax.swing.JComboBox<>();
        cboTimDongSp = new javax.swing.JComboBox<>();
        cboTimMauSac = new javax.swing.JComboBox<>();
        cboTimChatLieu = new javax.swing.JComboBox<>();
        cboTimSize = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        rdoMau = new javax.swing.JRadioButton();
        rdoSize = new javax.swing.JRadioButton();
        rdoDongSp = new javax.swing.JRadioButton();
        rdoNsx = new javax.swing.JRadioButton();
        rdoSanPham = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();

        lblThongTinChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongTinChiTietMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThongTinChiTietMouseEntered(evt);
            }
        });

        jLabel1.setText("Ma San Pham");

        jLabel2.setText("San Pham");

        jLabel3.setText("Dong Sp");

        jLabel4.setText("So Luong Ton");

        jLabel5.setText("Gia");

        jLabel6.setText("Mau Sac");

        jLabel7.setText("Chat Lieu");

        txtMoTa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoTaKeyReleased(evt);
            }
        });

        jLabel8.setText("Mo ta");

        jLabel9.setText("NSX");

        jLabel10.setText("Size");

        tblThongTinSp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblThongTinSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinSpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTinSp);

        jButton1.setText("<<|");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(">>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("|>>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jButton1)
                        .addGap(61, 61, 61)
                        .addComponent(jButton2)
                        .addGap(88, 88, 88)
                        .addComponent(jButton3)
                        .addGap(107, 107, 107)
                        .addComponent(jButton4)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        btnThemCtsp.setText("Them");
        btnThemCtsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCtspActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        cboSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboDongSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboNsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnXoaCtSp.setText("Xoa");
        btnXoaCtSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCtSpActionPerformed(evt);
            }
        });

        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKeyReleased(evt);
            }
        });

        btnXuatBar.setText("Xuat code_bar");
        btnXuatBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatBarActionPerformed(evt);
            }
        });

        btnXuatEcel.setText("XuatEcel");
        btnXuatEcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatEcelActionPerformed(evt);
            }
        });

        btnNhapEcel.setText("NhapEcel");
        btnNhapEcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapEcelActionPerformed(evt);
            }
        });

        jButton8.setText("Lam Moi");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        cboTimNsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTimNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimNsxActionPerformed(evt);
            }
        });

        cboTimSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTimSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimSpActionPerformed(evt);
            }
        });

        cboTimDongSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTimDongSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimDongSpActionPerformed(evt);
            }
        });

        cboTimMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTimMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimMauSacActionPerformed(evt);
            }
        });

        cboTimChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTimChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimChatLieuActionPerformed(evt);
            }
        });

        cboTimSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTimSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimSizeActionPerformed(evt);
            }
        });

        jLabel12.setText("Tìm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboSanPham, 0, 266, Short.MAX_VALUE)
                    .addComponent(cboDongSp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(btnThemCtsp)
                .addGap(61, 61, 61)
                .addComponent(btnSua)
                .addGap(59, 59, 59)
                .addComponent(btnXoaCtSp)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(351, 351, 351))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnXuatBar)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatEcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNhapEcel)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cboTimNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cboTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(cboTimDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cboTimMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(cboTimChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cboTimSize, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton8))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCtsp)
                    .addComponent(btnSua)
                    .addComponent(btnXoaCtSp)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatBar)
                    .addComponent(btnXuatEcel)
                    .addComponent(btnNhapEcel)
                    .addComponent(jButton8))
                .addGap(7, 7, 7)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboTimNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTimMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTimDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboTimChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimSize, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        lblThongTinChiTiet.addTab("Thong Tin Chi Tiet", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thuoc Tinh San Pham\n"));

        jLabel11.setText("Ten Thuoc Tinh");

        rdoMau.setText("Mau Sac");
        rdoMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMauMouseClicked(evt);
            }
        });

        rdoSize.setText("Size");
        rdoSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSizeMouseClicked(evt);
            }
        });

        rdoDongSp.setText("Dong Sp");
        rdoDongSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDongSpMouseClicked(evt);
            }
        });

        rdoNsx.setText("Nsx");
        rdoNsx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNsxMouseClicked(evt);
            }
        });

        rdoSanPham.setText("San Pham");
        rdoSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSanPhamMouseClicked(evt);
            }
        });

        rdoChatLieu.setText("Chat Lieu");
        rdoChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChatLieuMouseClicked(evt);
            }
        });
        rdoChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChatLieuActionPerformed(evt);
            }
        });

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoMau)
                            .addComponent(rdoNsx))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoSize)
                            .addComponent(rdoSanPham))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoChatLieu)
                            .addComponent(rdoDongSp)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnThem)
                        .addGap(52, 52, 52)
                        .addComponent(btnXoa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMau)
                    .addComponent(rdoSize)
                    .addComponent(rdoDongSp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNsx)
                    .addComponent(rdoSanPham)
                    .addComponent(rdoChatLieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
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
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        tblThuocTinh.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblThuocTinhPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        lblThongTinChiTiet.addTab("Thong Tinh Thuoc Tinh", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongTinChiTiet))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThongTinChiTiet)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMauMouseClicked
        // TODO add your handling code here:
        loadTblMau(chiTietSpServiceImpl.getMauSac());
    }//GEN-LAST:event_rdoMauMouseClicked

    private void rdoSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSizeMouseClicked
        // TODO add your handling code here:
        loadTblSize(chiTietSpServiceImpl.getSize());
    }//GEN-LAST:event_rdoSizeMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (rdoMau.isSelected() == true) {

            try {
                MauSac mauSac = new MauSac();
                if (txtTenThuocTinh.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, " dien mau sac");
                    return;
                }
                if (!checkMauSac()) {
                    JOptionPane.showMessageDialog(this, "da ton tai mau nay");
                    return;
                }
                mauSac.setTen(txtTenThuocTinh.getText());

                if (mauSacService.add(mauSac)) {
                    JOptionPane.showMessageDialog(this, "them mau thành công");
                    loadTblMau(chiTietSpServiceImpl.getMauSac());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rdoSize.isSelected() == true) {
            try {

                Size size = new Size();

                if (txtTenThuocTinh.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "dien size");
                    return;
                }
                if (!checkSize()) {
                    JOptionPane.showMessageDialog(this, "size da ton tai");
                    return;
                }
                size.setTen(txtTenThuocTinh.getText());

                if (sizeService.save(size)) {
                    JOptionPane.showMessageDialog(this, "Them size thành công");
                    loadTblSize(chiTietSpServiceImpl.getSize());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rdoDongSp.isSelected() == true) {
            try {
                DongSp dongSp = new DongSp();
                if (txtTenThuocTinh.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, " dien dongsp");
                    return;
                }
                if (!checkDongSp()) {
                    JOptionPane.showMessageDialog(this, "da ton tai");
                    return;
                }
                dongSp.setTen(txtTenThuocTinh.getText());

                if (dongSpService.add(dongSp)) {
                    JOptionPane.showMessageDialog(this, "Them thành công");
                    loadTblDongSp(chiTietSpServiceImpl.getDongSp());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rdoNsx.isSelected()) {
            try {
                Nsx nsx = new Nsx();
                if (txtTenThuocTinh.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "dien nsx");
                    return;
                }
                if (!checkNsx()) {
                    JOptionPane.showMessageDialog(this, "da ton tai");
                    return;
                }
                nsx.setTen(txtTenThuocTinh.getText());

                if (nSXService.save(nsx)) {
                    JOptionPane.showMessageDialog(this, "them thành công");
                    loadTblNsx(chiTietSpServiceImpl.getNsx());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rdoSanPham.isSelected()) {
            try {
                SanPham sp = new SanPham();
                if (txtTenThuocTinh.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "da ton tai san pham nay");
                    return;
                }
                if (!checkSanPham()) {
                    JOptionPane.showMessageDialog(this, "da ton tai san pham nay");
                    return;
                }
                sp.setTen(txtTenThuocTinh.getText());

                if (sanPhamServiceImpl.add(sp) == true) {
                    JOptionPane.showMessageDialog(this, "Them Thành công");
                    loadTblSanPham(sanPhamServiceImpl.getAll());
                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rdoChatLieu.isSelected()) {
            try {
                ChatLieu chatLieu = new ChatLieu();
                if (txtTenThuocTinh.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "da ton tai san pham nay");
                    return;
                }
                if (!checkChatLieu()) {
                    JOptionPane.showMessageDialog(this, "da ton tai chat lieu pham nay");
                    return;
                }
                chatLieu.setTen(txtTenThuocTinh.getText());

                if (chatLieuService.save(chatLieu)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadTblChatLieu(chiTietSpServiceImpl.getChatLieu());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            } catch (Exception e) {
            }
        }
        loadcbo();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (rdoSize.isSelected()) {
            try {
                int index = tblThuocTinh.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "Chua chon size de xoa");

                    return;
                }
                Size size = sizeService.getAll().get(index);

                if (sizeService.delete(size)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadTblSize(sizeService.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        } else if (rdoMau.isSelected()) {
            try {
                int index = tblThuocTinh.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "Chua cho mau de xoa");
                    return;
                }
                MauSac chatLieu = mauSacService.getAll().get(index);
                if (mauSacService.delete(chatLieu)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadTblMau(mauSacService.getAll());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lien quan san pham chi tiet");
                e.printStackTrace();
            }
        } else if (rdoDongSp.isSelected()) {
            try {
                int index = tblThuocTinh.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "Chua chon dong san pham xoa");
                }
                DongSp dongSp = dongSpService.getAll().get(index);
                if (dongSpService.delete(dongSp)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadTblDongSp(dongSpService.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
                e.printStackTrace();
            }
        } else if (rdoNsx.isSelected()) {
            try {
                int index = tblThuocTinh.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "Chua chon nsx de xoa");
                }
                Nsx chatLieu = nSXService.getNSX().get(index);
                if (nSXService.delete(chatLieu)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadTblNsx(nSXService.getNSX());
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
                e.printStackTrace();
            }
        } else if (rdoSanPham.isSelected()) {
            try {
                int index = tblThuocTinh.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "chua chon san pham de xoa");

                }
                SanPham SanPham = sanPhamServiceImpl.getAll().get(index);

                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");

                }
                if (sanPhamServiceImpl.Delete(SanPham)) {
                    JOptionPane.showMessageDialog(this, "Xóa Thành công");
                    loadTblSanPham(sanPhamServiceImpl.getAll());
                }
            } catch (Exception e) {
            }

        } else if (rdoChatLieu.isSelected()) {
            int index = tblThuocTinh.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "chua chon chat lieu xoa");
            }
            ChatLieu chatLieu = chatLieuService.getAll().get(index);
            if (chatLieuService.delete(chatLieu)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadTblChatLieu(chatLieuService.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void rdoDongSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDongSpMouseClicked
        // TODO add your handling code here:
        loadTblDongSp(chiTietSpServiceImpl.getDongSp());
        return;
    }//GEN-LAST:event_rdoDongSpMouseClicked

    private void rdoNsxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNsxMouseClicked
        // TODO add your handling code here:
        loadTblNsx(chiTietSpServiceImpl.getNsx());
        return;
    }//GEN-LAST:event_rdoNsxMouseClicked

    private void rdoSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSanPhamMouseClicked
        // TODO add your handling code here:
        loadTblSanPham(chiTietSpServiceImpl.getSanPham());
        return;
    }//GEN-LAST:event_rdoSanPhamMouseClicked

    private void rdoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChatLieuActionPerformed

    private void rdoChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChatLieuMouseClicked
        // TODO add your handling code here:
        loadTblChatLieu(chiTietSpServiceImpl.getChatLieu());
        return;
    }//GEN-LAST:event_rdoChatLieuMouseClicked

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        // TODO add your handling code here:
//        int index = tblThuocTinh.getSelectedRow();
//        txtTenThuocTinh.setText((String) tblThongTinSp.getValueAt(index, 1));

    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void btnThemCtspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCtspActionPerformed
        // TODO add your handling code here:
        try {
            List<ChiTietSp> list = chiTietSpServiceImpl.getAll();
            ChiTietSp chiTietSp = new ChiTietSp();

            if (txtMaSP.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "  khong dk de trong ma");
                return;
            }
            if (Integer.parseInt(txtSoLuongTon.getText()) <= 0 || txtSoLuongTon.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " phai la  so khong dk de trong");
                return;
            }
            if (Integer.parseInt(txtGia.getText()) <= 0 || txtGia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " phai la  so khong dk de trong");
                return;
            }

            chiTietSp.setSoLuongTon(Integer.parseInt(txtSoLuongTon.getText()));
            chiTietSp.setGia(Integer.parseInt(txtGia.getText()));
            chiTietSp.setMoTa(txtMoTa.getText());
            chiTietSp.setMactsp(txtMaSP.getText());

            int index2 = cboChatLieu.getSelectedIndex();
            ChatLieu chatLieu = chiTietSpServiceImpl.getChatLieu().get(index2);
            chiTietSp.setChatLieu(chatLieu);

            int index3 = cboDongSp.getSelectedIndex();
            DongSp sp = chiTietSpServiceImpl.getDongSp().get(index3);
            chiTietSp.setDongSp(sp);

            int index4 = cboSize.getSelectedIndex();
            Size size = chiTietSpServiceImpl.getSize().get(index4);
            chiTietSp.setSize(size);

            int index5 = cboNsx.getSelectedIndex();
            Nsx nsx = chiTietSpServiceImpl.getNsx().get(index5);
            chiTietSp.setNsx(nsx);

            int index6 = cboMauSac.getSelectedIndex();
            MauSac ms = chiTietSpServiceImpl.getMauSac().get(index6);
            chiTietSp.setMauSac(ms);

            int index7 = cboSanPham.getSelectedIndex();
            SanPham sanPham = chiTietSpServiceImpl.getSanPham().get(index7);
            chiTietSp.setSanPham(sanPham);

            if (chiTietSpRepository.getCheckTrung(sanPham.getId(), sp.getId(), ms.getId(), chatLieu.getId(), size.getId(), nsx.getId()).size() > 0) {
                JOptionPane.showMessageDialog(this, "Trung thuoc tinh");
                return;
            }

            if (chiTietSpServiceImpl.add(chiTietSp) == true) {
                JOptionPane.showMessageDialog(this, "them  thanh cong");
                loadTableCtSanPham(chiTietSpRepository.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "that bai");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "that bai");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemCtspActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            String id = txtMaSP.getText();
            ChiTietSp chiTietSp = chiTietSpServiceImpl.getOne(id);

            if (txtMaSP.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "  khong dk de trong ma");
                return;
            }
            if (Integer.parseInt(txtGia.getText()) <= 0 || txtGia.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, " phai la  so khong dk de trong");
                return;
            }
            if (Integer.parseInt(txtSoLuongTon.getText()) <= 0 || txtSoLuongTon.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, " phai la  so khong dk de trong");
                return;
            }
            chiTietSp.setMactsp(txtMaSP.getText());

            int index2 = cboChatLieu.getSelectedIndex();
            ChatLieu chatLieu = chiTietSpServiceImpl.getChatLieu().get(index2);
            chiTietSp.setChatLieu(chatLieu);

            int index3 = cboDongSp.getSelectedIndex();
            DongSp sp = chiTietSpServiceImpl.getDongSp().get(index3);
            chiTietSp.setDongSp(sp);

            int index4 = cboSize.getSelectedIndex();
            Size size = chiTietSpServiceImpl.getSize().get(index4);
            chiTietSp.setSize(size);

            int index5 = cboNsx.getSelectedIndex();
            Nsx nsx = chiTietSpServiceImpl.getNsx().get(index5);
            chiTietSp.setNsx(nsx);

            int index6 = cboMauSac.getSelectedIndex();
            MauSac ms = chiTietSpServiceImpl.getMauSac().get(index6);
            chiTietSp.setMauSac(ms);

            int index7 = cboSanPham.getSelectedIndex();
            SanPham sanPham = chiTietSpServiceImpl.getSanPham().get(index7);
            chiTietSp.setSanPham(sanPham);

            chiTietSp.setSoLuongTon(Integer.parseInt(txtSoLuongTon.getText()));
            chiTietSp.setGia(Integer.parseInt(txtGia.getText()));
            chiTietSp.setMoTa(txtMoTa.getText());

            Boolean check = false;
            
                for (ChiTietSp chiTietSp1 : list) {
                    if (chiTietSp1.getId() == chiTietSp.getId()) {
                        check = true;
                    }
                }
                if (check == false) {
                    if (chiTietSpRepository.getCheckTrung(sanPham.getId(), sp.getId(), ms.getId(), chatLieu.getId(), size.getId(), nsx.getId()).size() > 0) {
                        JOptionPane.showMessageDialog(this, "Trung thuoc tinh");
                        return;
                    }
                    
                }
            

            if (chiTietSpServiceImpl.update(chiTietSp) == true) {
                JOptionPane.showMessageDialog(this, "sua thanh cong");
                loadTableCtSanPham(chiTietSpRepository.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "that bai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblThongTinSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinSpMouseClicked
        // TODO add your handling code here:
        int index = tblThongTinSp.getSelectedRow();

        txtMaSP.setText(tblThongTinSp.getValueAt(index, 0).toString());
        cboChatLieu.setSelectedItem(tblThongTinSp.getValueAt(index, 1));
        cboDongSp.setSelectedItem(tblThongTinSp.getValueAt(index, 2));
        cboSize.setSelectedItem(tblThongTinSp.getValueAt(index, 3));
        cboNsx.setSelectedItem(tblThongTinSp.getValueAt(index, 4));
        cboMauSac.setSelectedItem(tblThongTinSp.getValueAt(index, 5));
        cboSanPham.setSelectedItem(tblThongTinSp.getValueAt(index, 6));
        txtSoLuongTon.setText(tblThongTinSp.getValueAt(index, 7).toString());
        txtGia.setText(tblThongTinSp.getValueAt(index, 8).toString());
        txtMoTa.setText(tblThongTinSp.getValueAt(index, 9).toString());
    }//GEN-LAST:event_tblThongTinSpMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        txtGia.setText("");
        txtMoTa.setText("");
        txtSoLuongTon.setText("");
        txtMaSP.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnXoaCtSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCtSpActionPerformed
        // TODO add your handling code here:
        try {
            if (txtMaSP.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, " Moi nhap ma");
                return;
            }
            String id = txtMaSP.getText();
            ChiTietSp chiTietSp = chiTietSpServiceImpl.getOne(id);
            chiTietSp.setMactsp(txtMaSP.getText());
            if (chiTietSpServiceImpl.delete(chiTietSp) == true) {
                JOptionPane.showMessageDialog(this, " xoa thanh cong");
                loadTableCtSanPham(chiTietSpServiceImpl.getAll());
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnXoaCtSpActionPerformed

    private void btnXuatBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatBarActionPerformed
        // TODO add your handling code here:
        int index = tblThongTinSp.getSelectedRow();

        qrcode qr = new qrcode();
        String id = tblThongTinSp.getValueAt(index, 0).toString();
        try {
            qr.output(id);
            JOptionPane.showMessageDialog(this, " xuat bar_code thanh cong thanh cong");
        } catch (WriterException ex) {
            Logger.getLogger(ChiTietSpJpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatBarActionPerformed

    private void btnXuatEcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatEcelActionPerformed
        // TODO add your handling code here:
        String CurentDirectoryFilePath = "F:\\Học liệu kì 4\\da1";
        JFileChooser execlExportChooser = new JFileChooser(CurentDirectoryFilePath);
        FileNameExtensionFilter excelFNEF = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        execlExportChooser.setFileFilter(excelFNEF);
        execlExportChooser.setDialogTitle("Luu excel... ");

        int excelChooser = execlExportChooser.showSaveDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook exceSSFWorkbookExprort = new XSSFWorkbook();
            XSSFSheet excelSheet = exceSSFWorkbookExprort.createSheet("Danh Sach");
            for (int i = 0; i < model.getRowCount(); i++) {
                XSSFRow excelRow = excelSheet.createRow(i);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    XSSFCell excelCell = excelRow.createCell(j);
                    excelCell.setCellValue(model.getValueAt(i, j).toString());
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
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXuatEcelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = tblThongTinSp.getSelectedRow();
        index = 0;
        tblThongTinSp.setRowSelectionInterval(index, index);
        showdata(index);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = tblThongTinSp.getSelectedRow();
        if (index > 0) {
            index--;
        }
        tblThongTinSp.setRowSelectionInterval(index, index);
        showdata(index);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = tblThongTinSp.getSelectedRow();
        if (index < list.size() - 1) {
            index++;
        }
        tblThongTinSp.setRowSelectionInterval(index, index);
        showdata(index);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int index = tblThongTinSp.getSelectedRow();
        index = list.size() - 1;
        tblThongTinSp.setRowSelectionInterval(index, index);
        showdata(index);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnNhapEcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapEcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhapEcelActionPerformed

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        // TODO add your handling code here:
        if (txtTim.getText().length() == 0) {
            loadTableCtSanPham(chiTietSpServiceImpl.getAll());
            return;
        } else {

            String id = txtTim.getText();
            ArrayList<ChiTietSp> lisy = chiTietSpRepository.getAll1(id);
            loadTableCtSanPham(lisy);
        }
    }//GEN-LAST:event_txtTimKeyReleased

    private void loadcbo() {
        loadTableCtSanPham(chiTietSpServiceImpl.getAll());
        loadCboSp(chiTietSpServiceImpl.getSanPham());
        loadCboChatLieu(chiTietSpServiceImpl.getChatLieu());
        loadCboDongSp(chiTietSpServiceImpl.getDongSp());
        loadCboSize(chiTietSpServiceImpl.getSize());
        loadCboNsx(chiTietSpServiceImpl.getNsx());
        hienThuocTinh();
        loadCboMauSac(chiTietSpServiceImpl.getMauSac());

        loadCboTimSp(chiTietSpRepository.getSanPham());
        loadCboTimChatLieu(chiTietSpServiceImpl.getChatLieu());
        loadCboTimDongSp(chiTietSpServiceImpl.getDongSp());
        loadCboTimSize(chiTietSpServiceImpl.getSize());
        loadCboTimNsx(chiTietSpServiceImpl.getNsx());
        loadCboTimMauSac(chiTietSpServiceImpl.getMauSac());

    }

    
//    private void timKiem(){
//        ArrayList<ChiTietSp> lst = new ArrayList<>();
//        for (ChiTietSp ctsp : chiTietSpRepository.getAll()) {
//            if(ctsp.getSanPham().getTen().contains(cbo){
//                lst.add(ctsp);
//            }
//        }
//        loadTableCtSanPham(lst);
//    }
    private void lblThongTinChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinChiTietMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblThongTinChiTietMouseClicked

    private void tblThuocTinhPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblThuocTinhPropertyChange
        // TODO add your handling code here:
        int index = tblThuocTinh.getSelectedRow();
        if (rdoMau.isSelected() == true) {
            txtTenThuocTinh.setText((String) tblThongTinSp.getValueAt(index, 1));
            return;
        }
        while (rdoSize.isSelected() == true) {
            txtTenThuocTinh.setText((String) tblThongTinSp.getValueAt(index, 1));
            return;
        }
    }//GEN-LAST:event_tblThuocTinhPropertyChange

    private void cboTimNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimNsxActionPerformed
        // TODO add your handling code here:

        int index5 = cboTimNsx.getSelectedIndex();
        Nsx nsx = chiTietSpServiceImpl.getNsx().get(index5);
        loadTableCtSanPham(chiTietSpServiceImpl.getTimNsx(nsx.getId()));
    }//GEN-LAST:event_cboTimNsxActionPerformed

    private void cboTimSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimSpActionPerformed
        // TODO add your handling code here:
        int index7 = cboTimSp.getSelectedIndex();
        SanPham sanPham = chiTietSpServiceImpl.getSanPham().get(index7);
        loadTableCtSanPham(chiTietSpServiceImpl.getTimSp(sanPham.getId()));
    }//GEN-LAST:event_cboTimSpActionPerformed

    private void cboTimDongSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimDongSpActionPerformed
        // TODO add your handling code here:
        int index3 = cboTimDongSp.getSelectedIndex();
        DongSp sp = chiTietSpServiceImpl.getDongSp().get(index3);
        loadTableCtSanPham(chiTietSpServiceImpl.getTimDong(sp.getId()));
    }//GEN-LAST:event_cboTimDongSpActionPerformed

    private void cboTimMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimMauSacActionPerformed
        // TODO add your handling code here:
        int index6 = cboTimMauSac.getSelectedIndex();
        MauSac ms = chiTietSpServiceImpl.getMauSac().get(index6);
        loadTableCtSanPham(chiTietSpServiceImpl.getTimMau(ms.getId()));
    }//GEN-LAST:event_cboTimMauSacActionPerformed

    private void cboTimChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimChatLieuActionPerformed
        // TODO add your handling code here:
        int index2 = cboTimChatLieu.getSelectedIndex();
        ChatLieu chatLieu = chiTietSpServiceImpl.getChatLieu().get(index2);
        loadTableCtSanPham(chiTietSpServiceImpl.getTimChatLieu(chatLieu.getId()));
    }//GEN-LAST:event_cboTimChatLieuActionPerformed

    private void cboTimSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimSizeActionPerformed
        // TODO add your handling code here:
        int index4 = cboTimSize.getSelectedIndex();
        Size size = chiTietSpServiceImpl.getSize().get(index4);
        loadTableCtSanPham(chiTietSpServiceImpl.getTimSize(size.getId()));
    }//GEN-LAST:event_cboTimSizeActionPerformed

    private void lblThongTinChiTietMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinChiTietMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblThongTinChiTietMouseEntered

    private void txtMoTaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoTaKeyReleased
        // TODO add your handling code here:
        // timKiem();
    }//GEN-LAST:event_txtMoTaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapEcel;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemCtsp;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaCtSp;
    private javax.swing.JButton btnXuatBar;
    private javax.swing.JButton btnXuatEcel;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboDongSp;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNsx;
    private javax.swing.JComboBox<String> cboSanPham;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboTimChatLieu;
    private javax.swing.JComboBox<String> cboTimDongSp;
    private javax.swing.JComboBox<String> cboTimMauSac;
    private javax.swing.JComboBox<String> cboTimNsx;
    private javax.swing.JComboBox<String> cboTimSize;
    private javax.swing.JComboBox<String> cboTimSp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane lblThongTinChiTiet;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoDongSp;
    private javax.swing.JRadioButton rdoMau;
    private javax.swing.JRadioButton rdoNsx;
    private javax.swing.JRadioButton rdoSanPham;
    private javax.swing.JRadioButton rdoSize;
    private javax.swing.JTable tblThongTinSp;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
